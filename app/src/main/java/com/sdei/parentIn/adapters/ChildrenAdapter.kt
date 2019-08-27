package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.model.ChildModel
import kotlinx.android.synthetic.main.item_children_fragment.view.*
import java.util.*

class ChildrenAdapter(var context: Context, var mData: ArrayList<ChildModel.DataBean>) : RecyclerView.Adapter<ChildrenAdapter.ChildrenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_children_fragment, parent, false)
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
        holder.txtChildDob.text = mData[position].birthDate.toString()
        holder.txtChildName.text = "${mData[position].firstName} ${mData[position].lastName}"
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner class ChildrenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var rvMain = itemView.rvMain
        var llSendMessage = itemView.llSendMessage
        var txtChildName = itemView.txtChildName
        var txtChildDob = itemView.txtChildDob
        var txtChildClass = itemView.txtChildClass
        var txtParentName = itemView.txtParentName

    }

}