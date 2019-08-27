package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import java.util.ArrayList

class MessagesAdapter(var context : Context, var msgList: ArrayList<String>) : RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_messages_fragment,parent,false)
        return MessagesViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return  msgList.size
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner  class MessagesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imgChild = ""
        var imgEditChild =""
        var txtChildName =""
        var txtChildDob =""

    }
}