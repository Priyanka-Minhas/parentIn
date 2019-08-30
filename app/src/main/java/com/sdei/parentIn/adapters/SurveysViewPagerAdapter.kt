package com.sdei.parentIn.adapters

import android.content.Context
import android.os.Build
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.viewpager.widget.PagerAdapter
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.OptionListDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.OptionsModel
import com.sdei.parentIn.model.SurveysModel
import com.sdei.parentIn.utils.showToast
import kotlinx.android.synthetic.main.item_survey.view.*


class SurveysViewPagerAdapter(private val mContext: Context,
                              private var mData: ArrayList<SurveysModel.DataBean>, var mClick: ClickInterface) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.item_survey, collection, false) as ViewGroup
        collection.addView(layout)
        setView(layout, position)

        return layout
    }

    fun notifyList(data: ArrayList<SurveysModel.DataBean>) {
        this.mData = data
        notifyDataSetChanged()
    }

    private fun setView(layout: ViewGroup, position: Int) {

        layout.txtQuestion.text = mData[position].question
        layout.txtCount.text = (position + 1).toString()
        layout.txtTotalCount.text = " " + mContext.resources.getString(R.string.de) + " " + mData.size

        if (position == 0) {
            layout.btnBack.visibility = View.GONE
        }

        layout.edtQuestionDropdown.setOnClickListener {
            val mArrayList = ArrayList<OptionsModel>()

            for (i in 0 until mData[position].options!!.size) {
                mArrayList.add(OptionsModel(i, mData[position].options!![i]))
            }

            OptionListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                    mArrayList,
                    mContext.getString(R.string.select_answer),
                    InterfacesCall.Callback { pos ->
                        layout.edtQuestionDropdown.setText(mArrayList[pos].name)
                    }).show()
        }

        layout.btnFollow.setOnClickListener {
            if (setAnswer(layout, position)) {
                mClick.moveToNextSurvey(position)
            } else {
                mContext.showToast(mContext.getString(R.string.please_answer_this_question))
            }
        }

        layout.btnBack.setOnClickListener {
            mClick.moveToBackSurvey(position)
        }

        when {
            mData[position].type!! == "m" -> {
                layout.lyQuestionOption.visibility = View.VISIBLE
                setMcqView(layout, position)
            }
            mData[position].type!! == "s" -> {
                layout.llSeekbar.visibility = View.VISIBLE
                setSeekBarView(layout, position)
            }
            mData[position].type!! == "d" -> {
                layout.llQuestionDropdown.visibility = View.VISIBLE

                if (!TextUtils.isEmpty(mData[position].answer)) {
                    layout.edtQuestionDropdown.setText(mData[position].answer!!)
                }
            }
            mData[position].type!! == "t" -> {
                layout.llQuestionAnswer.visibility = View.VISIBLE

                if (!TextUtils.isEmpty(mData[position].answer)) {
                    layout.edtQuestionAnswer.setText(mData[position].answer!!)
                }
            }
        }
    }

    private fun setSeekBarView(layout: ViewGroup, position: Int) {
        layout.sbQuestion.max = mData[position].max
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            layout.sbQuestion.min = mData[position].min
        }
        var progress = mData[position].min

        layout.txtSeekValue.text = layout.sbQuestion.progress.toString() + "/" + layout.sbQuestion.max

        layout.sbQuestion.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progressValue: Int, p2: Boolean) {
                progress = progressValue
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                layout.txtSeekValue.text = progress.toString() + "/" + seekBar!!.max
            }

        })
        if (!TextUtils.isEmpty(mData[position].answer)) {
            layout.sbQuestion.progress = mData[position].answer!!.toInt()
        }

    }

    private fun setMcqView(layout: ViewGroup, position: Int) {
        when {
            mData[position].options!!.size == 4 -> {

                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]
                layout.rbThree.text = mData[position].options!![2]
                layout.rbFour.text = mData[position].options!![3]

                if (!TextUtils.isEmpty(mData[position].answer)) {
                    when {
                        mData[position].answer == mData[position].options!![0] -> {
                            layout.rbOne.isChecked = true
                        }
                        mData[position].answer == mData[position].options!![1] -> {
                            layout.rbTwo.isChecked = true
                        }
                        mData[position].answer == mData[position].options!![2] -> {
                            layout.rbThree.isChecked = true
                        }
                        mData[position].answer == mData[position].options!![3] -> {
                            layout.rbFour.isChecked = true
                        }
                    }
                }
            }
            mData[position].options!!.size == 3 -> {

                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]
                layout.rbThree.text = mData[position].options!![2]

                layout.rbFour.visibility = View.GONE
                if (!TextUtils.isEmpty(mData[position].answer)) {
                    when {
                        mData[position].answer == mData[position].options!![0] -> {
                            layout.rbOne.isChecked = true
                        }
                        mData[position].answer == mData[position].options!![1] -> {
                            layout.rbTwo.isChecked = true
                        }
                        mData[position].answer == mData[position].options!![2] -> {
                            layout.rbThree.isChecked = true
                        }
                    }
                }
            }
            mData[position].options!!.size == 2 -> {

                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]

                layout.rbThree.visibility = View.GONE
                layout.rbFour.visibility = View.GONE

                if (!TextUtils.isEmpty(mData[position].answer)) {
                    when {
                        mData[position].answer == mData[position].options!![0] -> {
                            layout.rbOne.isChecked = true
                        }
                        mData[position].answer == mData[position].options!![1] -> {
                            layout.rbTwo.isChecked = true
                        }
                    }
                }
            }
        }

    }

    private fun setAnswer(layout: ViewGroup, position: Int): Boolean {
        when {
            mData[position].type!! == "m" -> {
                if (layout.rbOne.visibility == View.VISIBLE && layout.rbOne.isChecked) {
                    mData[position].answer = layout.rbOne.text.toString()
                } else if (layout.rbTwo.visibility == View.VISIBLE && layout.rbTwo.isChecked) {
                    mData[position].answer = layout.rbTwo.text.toString()
                } else if (layout.rbThree.visibility == View.VISIBLE && layout.rbThree.isChecked) {
                    mData[position].answer = layout.rbThree.text.toString()
                } else if (layout.rbFour.visibility == View.VISIBLE && layout.rbFour.isChecked) {
                    mData[position].answer = layout.rbFour.text.toString()
                }
            }
            mData[position].type!! == "s" -> {
                mData[position].answer = layout.sbQuestion.progress.toString()
            }
            mData[position].type!! == "d" -> {
                mData[position].answer = layout.edtQuestionDropdown.text.toString()
            }
            mData[position].type!! == "t" -> {
                mData[position].answer = layout.edtQuestionAnswer.text.toString()
            }
        }
        return !TextUtils.isEmpty(mData[position].answer!!.trim().toString())
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
        collection.removeView(view as View)
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    interface ClickInterface {
        fun moveToNextSurvey(currentPosition: Int)
        fun moveToBackSurvey(currentPosition: Int)
    }

}

