package com.sdei.parentIn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.MessageActivity
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(var context: MessageActivity,var msgList: ArrayList<String>): RecyclerView.Adapter<MessageAdapter.MsgViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message,parent,false)
        return MsgViewHolder(view)

    }

    override fun getItemCount(): Int {
        return  msgList.size
    }


    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {

    }

    inner  class MsgViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imgViewMsg = itemView.imgViewMsg
        var txtMsgChilName = itemView.txtMsgChildName
        var txtMsgChildSubName = itemView.txtMsgChildSubName
        var txtMsg = itemView.txtMsgFull
        var imgMsgPic = itemView.imgMsgPic

    }
}