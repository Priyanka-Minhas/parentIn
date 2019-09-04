package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.model.ChildModel
import kotlinx.android.synthetic.main.item_children.view.*
import java.util.*

class ChildrenAdapter(var context: Context, var mData: ArrayList<ChildModel.DataBean>,
                      var mClick: ClickInterface) : RecyclerView.Adapter<ChildrenAdapter.ChildrenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_children, parent, false)
        return ChildrenViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {

        holder.rvMain.setOnClickListener {
            if (holder.llSendMessage.visibility == View.VISIBLE) {
                holder.llSendMessage.visibility = View.GONE
            } else {
                holder.llSendMessage.visibility = View.VISIBLE
            }
        }

        if (position != 0 && position / 2 != 1) {
            holder.txtShortNameChild.background = ContextCompat.getDrawable(context,R.drawable.bg_round_dark_blue)
            holder.imgEditChild.setImageResource(R.drawable.ic_dark_blue_edit)
        } else {
            holder.txtShortNameChild.background = ContextCompat.getDrawable(context,R.drawable.bg_round_yellow)
            holder.imgEditChild.setImageResource(R.drawable.ic_yellow_child_edit)
        }

        holder.txtChildDob.text = mData[position].birthDate.toString()
        holder.txtSchool.text = mData[position].schoolName.toString()
        holder.txtChildName.text = "${mData[position].firstName} ${mData[position].lastName}"
        holder.txtTeacher.text = "${mData[position].teacherFirstName} ${mData[position].teacherLastName}"

        holder.txtShortNameChild.text = mData[position].firstName.substring(0, 1) + mData[position].lastName.substring(0, 1)

        holder.imgEditChild.setOnClickListener {
            mClick.editChild(position)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ChildrenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rvMain = itemView.rvMain
        var llSendMessage = itemView.llSendMessage
        var txtChildName = itemView.txtChildName
        var txtChildDob = itemView.txtChildDob
        var txtSchool = itemView.txtSchool
        var txtTeacher = itemView.txtTeacher
        var imgEditChild = itemView.imgEditChild
        var txtShortNameChild = itemView.imgChild
    }


    interface ClickInterface {
        fun editChild(pos: Int)
    }


}