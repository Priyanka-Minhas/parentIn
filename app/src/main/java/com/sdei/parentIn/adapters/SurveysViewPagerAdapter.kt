package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.sdei.parentIn.R
import com.sdei.parentIn.model.SurveysModel
import kotlinx.android.synthetic.main.item_survey.view.*
import java.util.*

class SurveysViewPagerAdapter(private val mContext: Context,
                                       private var mData: ArrayList<SurveysModel.DataBean>,var mClick: ClickInterface) : PagerAdapter() {

    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(mContext)
        val layout = inflater.inflate(R.layout.item_survey, collection, false) as ViewGroup
        collection.addView(layout)

        setView(layout, position)

        return layout
    }

    fun notifyList( data: ArrayList<SurveysModel.DataBean>){
        this.mData=data
        notifyDataSetChanged()
    }

    private fun setView(layout: ViewGroup, position: Int) {

        layout.txtQuestion.text = mData[position].question
        layout.txtTotalCount.text = (position + 1).toString() + " " + mContext.resources.getString(R.string.de) + " " + mData.size

        layout.btnFollow.setOnClickListener {
            mClick.moveToNextSurvey(position)
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
            }
            mData[position].options!!.size == 2 -> {
                layout.rbOne.text = mData[position].options!![0]
                layout.rbTwo.text = mData[position].options!![1]
            }
        }

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
    }

}
