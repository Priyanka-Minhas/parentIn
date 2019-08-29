package com.sdei.parentIn.adapters

import android.content.Context
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
                setMcqView(layout, position)
            }
            mData[position].type!! == "s" -> {
                layout.sbQuestion.visibility = View.VISIBLE
            }
            mData[position].type!! == "d" -> {
                layout.edtQuestionDropdown.visibility = View.VISIBLE
            }
            mData[position].type!! == "t" -> {
                layout.edtQuestionAnswer.visibility = View.VISIBLE
            }
        }
    }

    private fun setMcqView(layout: ViewGroup, position: Int) {
        layout.lyQuestionOption.visibility = View.VISIBLE
        when {
            mData[position].options!!.size == 4 -> {
                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]
                layout.rbThree.text = mData[position].options!![2]
                layout.rbFour.text = mData[position].options!![3]
            }
            mData[position].options!!.size == 3 -> {
                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]
                layout.rbThree.text = mData[position].options!![2]

                layout.rbFour.visibility = View.GONE
            }
            mData[position].options!!.size == 2 -> {
                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]

                layout.rbThree.visibility = View.GONE
                layout.rbFour.visibility = View.GONE
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
