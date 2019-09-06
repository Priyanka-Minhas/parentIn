package com.sdei.parentIn.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.MessageActivity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.MessagesModel
import com.sdei.parentIn.utils.getAppPref
import kotlinx.android.synthetic.main.item_messages_fragment.view.*
import java.util.*

class MessagesDialogAdapter(var context: Context, var mData: ArrayList<MessagesModel.DataBean>,
                            val callback: Callback) : RecyclerView.Adapter<MessagesDialogAdapter.MessagesViewHolder>() {
    private var mCallback: Callback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_messages_fragment, parent, false)
        return MessagesViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        if (position % 2 == 1) {
            holder.imgChild.background = ContextCompat.getDrawable(context, R.drawable.img_mtra_yellow)
            holder.txtMsgDate.setTextColor(ContextCompat.getColor(context, R.color.colorYellow))
            holder.btnResponder.background = ContextCompat.getDrawable(context, R.drawable.style_yellow_ovel)
            holder.btnResponder.setTextColor(ContextCompat.getColor(context, R.color.colorYellow))
        } else {
            holder.imgChild.background = ContextCompat.getDrawable(context, R.drawable.img_mtra_purpl)
            holder.txtMsgDate.setTextColor(ContextCompat.getColor(context, R.color.colorPurpulLight))
            holder.btnResponder.background = ContextCompat.getDrawable(context, R.drawable.style_purpul_ovel)
            holder.btnResponder.setTextColor(ContextCompat.getColor(context, R.color.colorPurpulLight))
        }

        holder.btnResponder.setOnClickListener {
            mCallback.getIndex(position)
        }

        holder.rvMain.setOnClickListener {
            val intent = Intent(context, MessageActivity::class.java)
             intent.putExtra(InterConst.KEY_FROM,mData[position].from)
             intent.putExtra(InterConst.KEY_TO,mData[position].to)
             context.startActivity(intent)
        }

        holder.txtshortmsg.text = mData[position].message
//      holder.txtMsgDate.text = mData[position].createdAt

        if (getAppPref().getString(InterConst.ID) != mData[position].from) {
            holder.txtName.text = mData[position].fromName
        } else {
            holder.txtName.text = mData[position].toName
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class MessagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgChild = itemView.txtShortName
        var txtName = itemView.txtName
        var txtshortmsg = itemView.txtshortmsg
        var txtMsgDate = itemView.txtMsgDate
        var btnResponder = itemView.btnResponder
        var rvMain = itemView.rvMain
    }

    interface Callback {
        fun getIndex(pos: Int)
    }
}