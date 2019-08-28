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

class ClassAdapter(var context: Context, var mData: ArrayList<String>) : RecyclerView.Adapter<ClassAdapter.ClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_classes, parent, false)
        return ClassViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        /*holder.rvMain.setOnClickListener {
            if (holder.llSendMessage.visibility == View.VISIBLE) {
                holder.llSendMessage.visibility = View.GONE
            } else {
                holder.llSendMessage.visibility = View.VISIBLE
            }
        }*/
       // holder.txtChildDob.text = mData[position].birthDate.toString()
       // holder.txtChildName.text = "${mData[position].firstName} ${mData[position].lastName}"
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       // var rvMain = itemView.rvMain
       //// var llSendMessage = itemView.llSendMessage
        var txtChildName = itemView.txtChildName
       // var txtChildDob = itemView.txtChildDob
       // var txtChildClass = itemView.txtChildClass
       // var txtParentName = itemView.txtParentName

    }

}