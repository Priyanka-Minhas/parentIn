package com.sdei.parentIn.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_teacher_new_account.*

class TeacherNewAccountActivity : BaseActivity<BaseViewModel>(), View.OnClickListener {


    override val layoutId: Int
        get() = R.layout.activity_teacher_new_account
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@TeacherNewAccountActivity

    override fun onCreate() {
    }

    override fun initListeners() {
      btnBack.setOnClickListener(this)
    }
    override fun onClick(view: View?) {
        when(view!!.id){
           R.id.btnBack->{
               finish()
           }
        }
    }

}
