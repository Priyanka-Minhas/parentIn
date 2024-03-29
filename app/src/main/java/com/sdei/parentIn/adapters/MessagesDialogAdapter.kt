package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
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
            if (getAppPref().getString(InterConst.ID) != mData[position].from) {
                mCallback.getIndex(position,mData[position].from,mData[position].fromName)
            } else {
                mCallback.getIndex(position,mData[position].to,mData[position].toName)
            }

        }

        holder.rvMain.setOnClickListener {
            mCallback.openActivity(position)
        }

        holder.txtshortmsg.text = mData[position].message

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
        var txtTeacherName = itemView.txtTeacherName
        var rvMain = itemView.rvMain
    }

    interface Callback {
        fun getIndex(pos: Int, from: String, fromName: String)
        fun openActivity(pos: Int)
    }
}