package com.sdei.parentIn.dialog

import android.content.Context
import android.os.Build
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Gravity
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.adapters.ParentMessageAddNameAdapter
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.ChildModel
import kotlinx.android.synthetic.main.dialog_message_select_name.*



class ParentMessageSelectNameDialog(context: Context,
                                    themeResId: Int,
                                    private val LayoutId: Int,
                                    var list: ArrayList<ChildModel.DataBean>,
                                    private val callback: IndexClick)
    : BaseListDialog(context, themeResId) {

    lateinit var mAdapterParent: ParentMessageAddNameAdapter
    val tempList = arrayListOf<ChildModel.DataBean>()

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

        tempList.addAll(list)

        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int,before: Int, count: Int) {
                tempList.clear()
                if(TextUtils.isEmpty(s.toString())){
                    tempList.addAll(list)
                }else {
                    for (k in 0 until list.size) {
                        if (list[k].firstName.toUpperCase().startsWith(s.toString().toUpperCase())) {
                            tempList.add(list[k])
                        }
                    }
                }
                if(tempList.isEmpty()){
                    txtNoResult.visibility=View.VISIBLE
                }else{
                    txtNoResult.visibility=View.GONE
                }

                setAdapter()
            }
        })

        txtSelectAll.setOnClickListener {
            callback.clickIndex(ChildModel.DataBean())
            dismiss()
        }

        setAdapter()
    }

    private fun setAdapter() {
        if (list.isNotEmpty()) {
            recyclerView!!.layoutManager = LinearLayoutManager(context)
            mAdapterParent = ParentMessageAddNameAdapter(context, tempList, indexClick)
            recyclerView!!.adapter = mAdapterParent
        }
    }

    override fun getContentView(): Int {
        return LayoutId
    }

    override fun clickIndex(pos: Int) {
        dismiss()
        callback.clickIndex(tempList[pos])
        mAdapterParent.notifyDataSetChanged()
    }

    interface IndexClick {
        fun clickIndex(pos: ChildModel.DataBean)
    }
}
