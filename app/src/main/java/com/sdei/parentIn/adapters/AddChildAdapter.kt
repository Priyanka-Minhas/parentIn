package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.model.ChildModel
import kotlinx.android.synthetic.main.item_add_child.view.*
import java.util.*

class AddChildAdapter(var con: Context,
                      var mData: ArrayList<ChildModel>,
                      var mClick: ClickInterface) : RecyclerView.Adapter<AddChildAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_add_child, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text= "${con.getString(R.string.nino)+" "}${position + 1}"

        holder.imgDelete.setOnClickListener {
            mClick.deleteChild(position)
        }

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgDelete = itemView.imgDelete!!
        var txtTitle = itemView.txtTitle!!
    }

    interface ClickInterface {
        fun deleteChild(pos: Int)
    }

}