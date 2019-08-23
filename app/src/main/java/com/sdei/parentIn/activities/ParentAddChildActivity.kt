package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.AddChildAdapter
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.ParentNewAccountViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import kotlinx.android.synthetic.main.activity_parent_add_child.*
import kotlinx.android.synthetic.main.item_add_child.*


class ParentAddChildActivity : BaseActivity<ParentNewAccountViewModel>(), View.OnClickListener, AddChildAdapter.ClickInterface {

    override fun deleteChild(pos: Int) {
        mData.removeAt(pos)
        mChildAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddChild -> {
                mData.add(UserModel.DataBean.ChildsBean())
                mChildAdapter.notifyDataSetChanged()
            }

            R.id.txtCreateAccount -> {
                val i = intent
                val model = i.getParcelableExtra(DATA) as UserModel.DataBean

                for(i in 0..mData.size-1){
                 if(mData[i].firstName.isEmpty()){
                     showAlertSnackBar(txtCreateAccount,getString(R.string.errorChildFirstName)+i)
                 }else if(!edtChildLastName.nonEmpty()){
                     showAlertSnackBar(txtCreateAccount,getString(R.string.errorChildLastName)+i)
                 }else if(!edtChildIdentityCard.nonEmpty()){
                     showAlertSnackBar(txtCreateAccount,getString(R.string.errorIdentification)+i)
                 }else if(!edtChildGender.nonEmpty()){
                     showAlertSnackBar(txtCreateAccount,getString(R.string.errorChildGender)+i)
                 }else if(!edtChildBirthDate.nonEmpty()){
                     showAlertSnackBar(txtCreateAccount,getString(R.string.errorBirthday)+i)
                 }
                }
               /* if (mData.size == 0) {
                    showAlertSnackBar(txtCreateAccount, getString(R.string.errorChild))
                    return
                }*/
                model.noOfStudents = mData.size

                if (connectedToInternet(btnAddChild)) {
                  //  mViewModel!!.setProfile(model)
                }
            }

            R.id.btnBack -> {
                finish()
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_parent_add_child

    override val viewModel: ParentNewAccountViewModel
        get() = ViewModelProviders.of(this).get(ParentNewAccountViewModel::class.java)

    override val context: Context
        get() = this@ParentAddChildActivity

    var mData = arrayListOf<UserModel.DataBean.ChildsBean>()

    lateinit var mChildAdapter: AddChildAdapter

    override fun onCreate() {
        mData.add(UserModel.DataBean.ChildsBean())
        setChildAdapter()

        mViewModel!!.getProfile().observe(this,
                Observer<UserModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        showToast(getString(R.string.work_in_progress))
                    }
                })


        // get school list

        mViewModel!!.getSchoolList().observe(this,
                Observer<SchoolModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        //showToast(getString(R.string.work_in_progress))
                    }
                })

    }

    override fun initListeners() {
        btnAddChild.setOnClickListener(this)
        txtCreateAccount.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    private fun setChildAdapter() {
        rvAddChild.layoutManager = LinearLayoutManager(mContext)
        mChildAdapter = AddChildAdapter(mContext, mData, this)
        rvAddChild.adapter = mChildAdapter
    }

}
