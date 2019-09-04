package com.sdei.parentIn.dialog

import android.content.Context
import android.os.Build
import android.view.Gravity
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.adapters.TeacherMessageAddNameAdapter
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.ClassModel
import kotlinx.android.synthetic.main.dialog_options.*

class TeacherMessageSelectNameDialog(context: Context,
                                     themeResId: Int,
                                     private val LayoutId: Int,
                                     var list: ArrayList<ClassModel.DataBean>,
                                     private val callback: InterfacesCall.Callback)
    : BaseListDialog(context, themeResId) {

    lateinit var mAdapterParent: TeacherMessageAddNameAdapter

    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        window!!.attributes = wmlp
    }

    override fun getInterfaceInstance(): InterfacesCall.IndexClick {
        return this
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateStuff() {
        if (list.isNotEmpty()) {
            recyclerView!!.layoutManager = LinearLayoutManager(context)
            mAdapterParent = TeacherMessageAddNameAdapter(context, list, indexClick)
            recyclerView!!.adapter = mAdapterParent
        }
    }

    override fun getContentView(): Int {
        return LayoutId
    }

    override fun clickIndex(pos: Int) {
        callback.selected(pos)
        mAdapterParent.notifyDataSetChanged()
    }
}
