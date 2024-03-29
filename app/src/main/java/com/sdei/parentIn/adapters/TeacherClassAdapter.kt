package com.sdei.parentIn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.model.ClassModel
import kotlinx.android.synthetic.main.item_classes.view.*
import java.util.*

class TeacherClassAdapter(var context: Context, var mData: ArrayList<ClassModel.DataBean>) : RecyclerView.Adapter<TeacherClassAdapter.ClassViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_classes, parent, false)
        return ClassViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        holder.cvMain.setOnClickListener {
            if (holder.lySendMessage.visibility == View.VISIBLE) {
                holder.lySendMessage.visibility = View.GONE
                holder.cvMain.setCardBackgroundColor(context.resources.getColor(R.color.white))

            } else {
                holder.lySendMessage.visibility = View.VISIBLE
                holder.cvMain.setCardBackgroundColor(context.resources.getColor(R.color.grayLight))
            }
        }
        holder.studentName.text = """${mData[position].firstName} ${mData[position].lastName}"""
        holder.father.text = """${mData[position].parentFirstName.toString()} ${mData[position].parentLastName}"""
        holder.fecNo.text = mData[position].birthDate.toString()

        if(mData[position].isSurvey!!){
            holder.imgSurvey.setImageResource(R.drawable.ic_right)
        }else {
            holder.imgSurvey.setImageResource(R.drawable.ic_cross)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner class ClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var studentName = itemView.txtStu
        var fecNo = itemView.txtFecNec
        var father = itemView.txtPadre
        var imgSurvey = itemView.imgCrossRight
        var cvMain = itemView.cvMain
        var lySendMessage = itemView.lySendMessage
    }

}