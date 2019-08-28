package com.sdei.parentIn.fragments.teacher

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.TeacherClassAdapter
import com.sdei.parentIn.dialog.TeacherAddChildDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.teacher.TeacherClassViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.fragment_class.*

/**
 * Fragment to show class list
 */
class TeacherClassFragment : BaseFragment<TeacherClassViewModel>(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnAddStuManually->{
                mDialog = TeacherAddChildDialog(mContext, R.style.pullBottomfromTop,
                        R.layout.dialog_teacher_add_child){ mData ->

                    if(mData.child!!.firstName!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorFirstName))
                    }else if(mData.child!!.lastName!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorLastName))
                    }else if(mData.child!!.birthDate!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorBirthday))
                    }else if(mData.child!!.verificationCard!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorIdentification))
                    } else if(mData.firstName!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorFirstName))
                    }else if(mData.lastName!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorLastName))
                    }else if(mData.emailAddress!!.isEmpty()){
                        mContext.showToast(getString(R.string.errorEmail))
                    }else if(!mData.emailAddress!!.validEmail()){
                        mContext.showToast(getString(R.string.errorValidEmail))
                    }else{

                        if(mContext.connectedToInternet()){
                            mContext.showProgess()
                            mViewModel!!.sendRedToAddStudent(mData)
                        }
                    }

                }.show()
            }
        }

    }

    lateinit var  mDialog: Unit

    var classList = ArrayList<ClassModel.DataBean>()
    lateinit var classAdapter: TeacherClassAdapter
    override val layoutId: Int
        get() = R.layout.fragment_class
    override val viewModel: TeacherClassViewModel
        get() = ViewModelProviders.of(this).get(TeacherClassViewModel::class.java)

    override fun onCreateStuff() {
        setClassListAdapter()
        mContext.showProgess()
        // make request
        mViewModel!!.hitClassListByTeacherApi(getAppPref().getString(InterConst.ID)!!)

        // get response

        mViewModel!!.getClass().observe(this, Observer<ClassModel> {mData ->
            if (mData != null && mContext.responseHandler(mData.statusCode, mData.message)) {
                classList = mData.data
                setClassListAdapter()
            }
        })

        // check add student status

        mViewModel!!.getAddStudentStatus().observe(this, Observer<BaseModel> {mData ->
             if(mData != null && mContext.responseHandler(mData.statusCode, mData.message)){
                 (mDialog as TeacherAddChildDialog).dismiss()
             }
        })

    }

    private fun setClassListAdapter() {
        rvTeacherClass.layoutManager = LinearLayoutManager(mContext)
        classAdapter = TeacherClassAdapter(mContext,classList)
        rvTeacherClass.adapter = classAdapter

    }

    override fun initListeners() {
      //rvTeacherClass.addOnItemTouchListener()
        btnAddStuManually.setOnClickListener(this)
    }

}
