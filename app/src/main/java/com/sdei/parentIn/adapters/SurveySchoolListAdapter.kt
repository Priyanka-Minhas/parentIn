package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SurveySchoolModel
import kotlinx.android.synthetic.main.item_options.view.*
import java.util.*

class SurveySchoolListAdapter(var con: Context,
                              var mData: ArrayList<SurveySchoolModel.DataBean>,
                              var mClick: InterfacesCall.IndexClick) : RecyclerView.Adapter<SurveySchoolListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_options, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtOption.text = mData[position].schoolName
        holder.llOption.setOnClickListener {
            mClick.clickIndex(position)
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val llOption = itemView.llOption!!
        val txtOption = itemView.txtOption!!
    }
}