package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.model.SurveysModel
import kotlinx.android.synthetic.main.item_survey_multiple_answer.view.*
import java.util.*

class MultiAnsSurveyAdapter(var con: Context,
                            var mData: ArrayList<SurveysModel.DataBean.OptionsBean>,
                            var mClick: ClickInterface) : RecyclerView.Adapter<MultiAnsSurveyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_survey_multiple_answer, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.checkBox.text = mData[position].label
        holder.checkBox.isChecked = mData[position].isChecked

        holder.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked){
                mClick.addAnswer(position)
            }else{
                mClick.removeAnswer(position)
            }

        }

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkBox = itemView.checkBox
    }

    interface ClickInterface {
        fun addAnswer(pos: Int)
        fun removeAnswer(pos: Int)
    }
}












