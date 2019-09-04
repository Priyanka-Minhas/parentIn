package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.model.ClassModel
import kotlinx.android.synthetic.main.item_message_add_name.view.*

class TeacherMsgNameAddedAdapter(var context: Context, var mData: ArrayList<ClassModel.DataBean>,
                                 var mClick: ClickInterface) : RecyclerView.Adapter<TeacherMsgNameAddedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_message_add_name, parent, false)
        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtChildName.text = mData[position].firstName
        holder.txtParentName.text = mData[position].parentFirstName
        holder.imgDelete.setOnClickListener {
            mClick.deleteChild(position)
        }
        holder.txtShortName.text = mData[position].firstName!!.substring(0, 1) + mData[position].lastName!!.substring(0, 1)
        if (position % 2 == 0) {
            holder.txtShortName.background = ContextCompat.getDrawable(context,R.drawable.bg_round_dark_blue)
        } else {
            holder.txtShortName.background = ContextCompat.getDrawable(context,R.drawable.bg_round_yellow)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtChildName = itemView.txtChildName
        var txtParentName = itemView.txtParentName
        var imgDelete = itemView.imgDelete
        var txtShortName = itemView.txtShortName
    }


    interface ClickInterface {
        fun deleteChild(pos: Int)
    }


}