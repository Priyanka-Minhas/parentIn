package com.sdei.parentIn.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_new_message.*

class NewMessageActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {


    override val layoutId: Int
        get() = R.layout.activity_new_message
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@NewMessageActivity

    override fun onCreate() {


    }

    override fun initListeners() {
        btnBack.setOnClickListener(this)
        txtSubmit.setOnClickListener(this)
        imgAdd.setOnClickListener(this)
        layoutAttach.setOnClickListener(this)


    }
    override fun onClick(view: View?) {
         when(view!!.id){
             R.id.btnBack ->{
                 finish()
             }
             R.id.imgAdd -> {

             }
             R.id.layoutAttach -> {

             }
         }
    }

}
