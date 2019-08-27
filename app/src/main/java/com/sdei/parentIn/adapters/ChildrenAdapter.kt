package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R

import java.util.ArrayList

class ChildrenAdapter(var context : Context,var childrenList: ArrayList<String>): RecyclerView.Adapter<ChildrenAdapter.ChildrenViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildrenViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_children_fragment,parent,false)
        return ChildrenViewHolder(layout)
    }

    override fun getItemCount(): Int {
       return  childrenList.size
    }

    override fun onBindViewHolder(holder: ChildrenViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner  class ChildrenViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imgChild = ""
        var imgEditChild =""
        var txtChildName =""
        var txtChildDob =""

    }

}