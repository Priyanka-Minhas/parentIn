package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import kotlinx.android.synthetic.main.item_messages_fragment.view.*
import java.util.ArrayList

class ParentMessagesAdapter(var context: Context, var msgList: ArrayList<String>, val callback:Callback) : RecyclerView.Adapter<ParentMessagesAdapter.MessagesViewHolder>() {
   private var mCallback :Callback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_messages_fragment,parent,false)
        return MessagesViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return  msgList.size
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        if(position % 2 == 1){
          holder.imgChild.background = ContextCompat.getDrawable(context,R.drawable.img_mtra_yellow)
          holder.txtMsgDate.setTextColor(ContextCompat.getColor(context,R.color.colorYellow))
          holder.btnResponder.background=ContextCompat.getDrawable(context,R.drawable.style_yellow_ovel)
          holder.btnResponder.setTextColor(ContextCompat.getColor(context,R.color.colorYellow))
        }else {
            holder.imgChild.background = ContextCompat.getDrawable(context,R.drawable.img_mtra_purpl)
            holder.txtMsgDate.setTextColor(ContextCompat.getColor(context,R.color.colorPurpulLight))
            holder.btnResponder.background=ContextCompat.getDrawable(context,R.drawable.style_purpul_ovel)
            holder.btnResponder.setTextColor(ContextCompat.getColor(context,R.color.colorPurpulLight))
        }

        holder.btnResponder.setOnClickListener {
            mCallback.getIndex(position)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner  class MessagesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imgChild = itemView.imgChild
        var txtMsgDate =itemView.txtMsgDate
        var btnResponder = itemView.btnResponder
    }

    interface Callback{
        fun getIndex(pos:Int)
    }
}