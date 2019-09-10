package com.sdei.parentIn.activities.parent

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.activities.WelcomeActivity
import com.sdei.parentIn.adapters.AddChildAdapter
import com.sdei.parentIn.dialog.SchoolListDialog
import com.sdei.parentIn.dialog.TeacherListListDialog
import com.sdei.parentIn.interfaces.InterConst.PARENT_DATA
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.parent.ParentAddChildViewModel
import kotlinx.android.synthetic.main.activity_parent_add_child.*


class ParentAddChildActivity : BaseActivity<ParentAddChildViewModel>(), View.OnClickListener, AddChildAdapter.ClickInterface {

    fun getSchoolList(returnValue: (SchoolModel.DataBean) -> Unit) {
        SchoolListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                mSchoolList,
                getString(R.string.select_school),
                InterfacesCall.Callback { pos ->
                    returnValue(mSchoolList[pos])
                }).show()
    }

    fun getTeacherList(schoolId: String, returnValue: (TeacherModel.DataBean) -> Unit) {
        if (connectedToInternet(btnAddChild)) {
            showProgess()
            mViewModel!!.hitTeacherListApi(schoolId) {
                if (responseHandler(it.statusCode, it.message)) {
                    TeacherListListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                            it.data,
                            getString(R.string.select_teacher),
                            InterfacesCall.Callback { pos ->
                                returnValue(it.data!![pos])
                            }).show()
                }
            }
        }
    }

    override fun deleteChild(pos: Int) {
        mChildList.removeAt(pos)
        mChildAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btnAddChild -> {
                mChildList.add(UserModel.ChildsBean())
                mChildAdapter.notifyDataSetChanged()
            }

            R.id.txtCreateAccount -> {

                val model = intent.getParcelableExtra(PARENT_DATA) as UserModel.DataBeanRequest

                for (i in 0 until mChildList.size) {
                    val childNo = i + 1
                    when {
                        mChildList[i].firstName.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildFirstName) + " " + childNo)
                            return
                        }
                        mChildList[i].lastName.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildLastName) + " " + childNo)
                            return
                        }
                        mChildList[i].verificationCard.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildIdentification) + " " + childNo)
                            return
                        }
                        mChildList[i].gender.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorChildGender) + " " + childNo)
                            return
                        }
                        mChildList[i].birthDate.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorBirthday) + " " + childNo)
                            return
                        }
                        mChildList[i].school_name.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorSchool) + " " + childNo)
                            return
                        }
                        /*mChildList[i].teacher_name.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorTeacher) + " " + childNo)
                            return
                        }*/
                        !mChildList[i].isSameAddressAsStudent && mChildList[i].homeAddress.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorStudentAddress))
                            return
                        }
                    }
                }

                model.noOfStudents = mChildList.size.toString()

                model.childs.addAll(mChildList)

                if (connectedToInternet(btnAddChild)) {
                    showProgess()
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

    override val viewModel: ParentAddChildViewModel
        get() = ViewModelProviders.of(this).get(ParentAddChildViewModel::class.java)

    override val context: Context
        get() = this@ParentAddChildActivity

    var mChildList = arrayListOf<UserModel.ChildsBean>()
    var mSchoolList = arrayListOf<SchoolModel.DataBean>()

    lateinit var mChildAdapter: AddChildAdapter

    override fun onCreate() {
        mChildList.add(UserModel.ChildsBean())
        setChildAdapter()
        mViewModel!!.getProfile().observe(this,
                Observer<UserModel> { mData ->
                    if (mData != null && responseHandler(mData.statusCode, mData.message)) {
                        showToast(getString(R.string.registered_successfully))
                        val intent = Intent(mContext, WelcomeActivity::class.java)
                        startActivity(intent)
                        finishAffinity()
                    }
                })

        mViewModel!!.getSchoolList().observe(this,
                Observer<ArrayList<SchoolModel.DataBean>> { mData ->
                    mSchoolList.addAll(mData)
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
