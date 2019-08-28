package com.sdei.parentIn.activities.parent

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.EditChildAdapter
import com.sdei.parentIn.dialog.SchoolListDialog
import com.sdei.parentIn.dialog.TeacherListDialog
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.BaseModel
import com.sdei.parentIn.model.ChildModel
import com.sdei.parentIn.model.SchoolModel
import com.sdei.parentIn.model.TeacherModel
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showAlertSnackBar
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.parent.ParentEditChildViewModel
import kotlinx.android.synthetic.main.activity_parent_edit_child.*

class ParentEditChildActivity : BaseActivity<ParentEditChildViewModel>(), View.OnClickListener, EditChildAdapter.ClickInterface {

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
        mViewModel!!.hitTeacherListApi(schoolId) {
            if (responseHandler(it.statusCode, it.message)) {
                TeacherListDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        it.data,
                        getString(R.string.select_teacher),
                        InterfacesCall.Callback { pos ->
                            returnValue(it.data!![pos])
                        }).show()
            }
        }
    }

    override fun deleteChild(pos: Int) {
        mChildList.removeAt(pos)
        mChildAdapter.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.txtCreateAccount -> {
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
                        mChildList[i].schoolName.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorSchool) + " " + childNo)
                            return
                        }
                        mChildList[i].teacherFirstName.isNullOrEmpty() -> {
                            showAlertSnackBar(txtCreateAccount, getString(R.string.errorTeacher) + " " + childNo)
                            return
                        }
                    }
                }

                if (connectedToInternet(btnBack)) {
                    showProgess()
                    if (intent.hasExtra(InterConst.CHILD_DATA)) {
                        mViewModel!!.hitChildUpdateApi(mChildList[0])
                    } else {
                        mViewModel!!.hitChildAddApi(mChildList[0])
                    }
                }
            }

            R.id.btnBack -> {
                finish()
            }
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_parent_edit_child

    override val viewModel: ParentEditChildViewModel
        get() = ViewModelProviders.of(this).get(ParentEditChildViewModel::class.java)

    override val context: Context
        get() = this

    var mChildList = arrayListOf<ChildModel.DataBean>()
    var mSchoolList = arrayListOf<SchoolModel.DataBean>()

    lateinit var mChildAdapter: EditChildAdapter

    override fun onCreate() {
        if (intent.hasExtra(InterConst.CHILD_DATA)) {
            val model = intent.getParcelableExtra(InterConst.CHILD_DATA) as ChildModel.DataBean
            mChildList.add(model)
        } else {
            mChildList.add(ChildModel.DataBean())
        }

        setChildAdapter()

        mViewModel!!.getSchoolList().observe(this,
                Observer<ArrayList<SchoolModel.DataBean>> { mData ->
                    mSchoolList.addAll(mData)
                })


        mViewModel!!.getChildUpdateStatus().observe(this,
                Observer<BaseModel> { mData ->
                    if (responseHandler(mData.statusCode, mData.message)) {
                        setResult(Activity.RESULT_OK)
                        finish()
                    }
                })
    }

    override fun initListeners() {
        txtCreateAccount.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    private fun setChildAdapter() {
        rvAddChild.layoutManager = LinearLayoutManager(mContext)
        mChildAdapter = EditChildAdapter(mContext, mChildList, this)
        rvAddChild.adapter = mChildAdapter
    }

}
