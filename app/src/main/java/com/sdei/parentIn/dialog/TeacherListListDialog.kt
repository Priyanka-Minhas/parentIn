package com.sdei.parentIn.dialog

import android.content.Context
import android.os.Build
import android.view.Gravity
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.adapters.ParentListAdapter
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.TeacherModel
import kotlinx.android.synthetic.main.dialog_options.*
import java.util.*

class TeacherListListDialog(
        context: Context,
        themeResId: Int,
        private val LayoutId: Int,
        var list: ArrayList<TeacherModel.DataBean>?,
        title: String,
        private val callback: InterfacesCall.Callback
) : BaseListDialog(context, themeResId) {

    lateinit var mAdapter: ParentListAdapter
    var title: String
    init {
        val wmlp = this.window!!.attributes
        wmlp.gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
        window!!.attributes = wmlp
        this.title = title
    }

    override fun getInterfaceInstance(): InterfacesCall.IndexClick {
        return this
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateStuff() {
        if (list!!.isNotEmpty()) {
            recyclerView!!.layoutManager = LinearLayoutManager(context)
            mAdapter = ParentListAdapter(context, list!!, indexClick)
            recyclerView!!.adapter = mAdapter
            txtTitle.text = title
        }
    }

    override fun getContentView(): Int {
        return LayoutId
    }

    override fun clickIndex(pos: Int) {
        dismiss()
        callback.selected(pos)
        mAdapter.notifyDataSetChanged()
    }
}
