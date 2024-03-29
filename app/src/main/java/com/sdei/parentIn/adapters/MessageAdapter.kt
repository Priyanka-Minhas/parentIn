package com.sdei.parentIn.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.MessageActivity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.getFormatDate
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(var context: MessageActivity, var msgList: ArrayList<MessagesModel.DataBean>) : RecyclerView.Adapter<MessageAdapter.MsgViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MsgViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MsgViewHolder(view)

    }

    override fun getItemCount(): Int {
        return msgList.size
    }


    override fun onBindViewHolder(holder: MsgViewHolder, position: Int) {
        holder.txtMsg.text = msgList[position].message
        holder.txtMsgSubDate.text = context.getFormatDate(msgList[position].createdAt)

        if (getAppPref().getString(InterConst.ID) != msgList[position].from) {
            holder.imgViewMsg.text = msgList[position].toName.substring(0, 1)
            holder.imgViewMsg.visibility = View.VISIBLE
            holder.txtMsgSubDate.setTextColor(ContextCompat.getColor(context, R.color.colorPurpulLight))
            holder.txtMsgChildSubName.text = msgList[position].toName
        } else {
            holder.imgViewMsg.text = msgList[position].fromName.substring(0, 1)
            holder.imgViewMsg.visibility = View.GONE
            holder.txtMsgSubDate.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            holder.txtMsgChildSubName.text = msgList[position].fromName
        }

        // for Attachment
        if (!msgList[position].attachment.isEmpty()) {
            holder.imgMsgPic.visibility = View.VISIBLE
            Glide.with(context).load(msgList[position].attachment).into(holder.imgMsgPic)
        } else {
            holder.imgMsgPic.visibility = View.GONE
        }

    }

    inner class MsgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgViewMsg = itemView.imgViewMsg
        var txtMsgChilName = itemView.txtMsgChildName
        var txtMsgChildSubName = itemView.txtMsgChildSubName
        var txtMsg = itemView.txtMsgFull
        var imgMsgPic = itemView.imgMsgPic
        var txtMsgDate = itemView.txtMsgDate
        var txtMsgSubDate = itemView.txtMsgSubDate

    }
}