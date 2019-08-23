package com.sdei.parentIn.activities

import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.AddChildAdapter
import com.sdei.parentIn.dialog.SchoolListDialog
import com.sdei.parentIn.dialog.TeacherListDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.utils.InterConstants.EXTRA_DATA
import com.sdei.parentIn.viewModel.ParentNewAccountViewModel
import kotlinx.android.synthetic.main.activity_parent_add_child.*


class ParentAddChildActivity : BaseActivity<ParentNewAccountViewModel>(), View.OnClickListener, AddChildAdapter.ClickInterface {

    fun getSchoolList(returnValue: (SchoolModel.DataBean) -> Unit) {
        SchoolListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                mSchoolList,
                getString(R.string.select_school),
                InterfacesCall.Callback { pos ->
                    returnValue(mSchoolList[pos])
                }).show()
    }

    fun getTeacherList(schoolId: String, returnValue: (TeacherModel.DataBean) -> Unit) {
        showProgess()

        mViewModel!!.hitTeacherListApi(schoolId)

        mViewModel!!.getTeacherList().observe(this,
                Observer<TeacherModel> {
                    if (it != null && responseHandler(it.statusCode, it.message)) {
                        mTeacherList.clear()
                        mTeacherList.addAll(it.data!!)

                        TeacherListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                                mTeacherList,
                                getString(R.string.select_school),
                                InterfacesCall.Callback { pos ->
                                    returnValue(mTeacherList[pos])
                                }).show()

                    }
                })

    }

    override fun deleteChild(pos: Int) {
        mChildList.removeAt(pos)
        mChildAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddChild -> {
                mChildList.add(UserModel.DataBean.ChildsBean())
                mChildAdapter.notifyDataSetChanged()
            }

            R.id.txtCreateAccount -> {
                val model = intent.getParcelableExtra(EXTRA_DATA) as UserModel.DataBean
                for (i in 0 until mChildList.size) {
                    var childNo = i + 1

                    if (mChildList[i].firstName.isNullOrEmpty()) {
                        showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildFirstName) + " " + childNo)
                        return
                    } else if (mChildList[i].lastName.isNullOrEmpty()) {
                        showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildLastName) + " " + childNo)
                        return
                    } else if (mChildList[i].verificationCard.isEmpty()) {
                        showAlertSnackBar(txtCreateAccount, getString(R.string.errorIdentification) + " " + childNo)
                        return
                    } else if (mChildList[i].gender.isEmpty()) {
                        showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildGender) + " " + childNo)
                        return
                    } else if (mChildList[i].birthDate.isEmpty()) {
                        showAlertSnackBar(txtCreateAccount, getString(R.string.errorBirthday) + " " + childNo)
                        return
                    }
                }

                model.noOfStudents = mChildList.size

                if (connectedToInternet(btnAddChild)) {
                    mViewModel!!.setProfile(model)
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

    var mChildList = arrayListOf<UserModel.DataBean.ChildsBean>()
    var mSchoolList = arrayListOf<SchoolModel.DataBean>()
    var mTeacherList = arrayListOf<TeacherModel.DataBean>()

    lateinit var mChildAdapter: AddChildAdapter

    override fun onCreate() {
        mChildList.add(UserModel.DataBean.ChildsBean())
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
                        mSchoolList.addAll(mData.data!!)
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
        mChildAdapter = AddChildAdapter(mContext, mChildList, this)
        rvAddChild.adapter = mChildAdapter
    }

}
