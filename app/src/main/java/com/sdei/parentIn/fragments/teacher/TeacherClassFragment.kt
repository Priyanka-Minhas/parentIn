package com.sdei.parentIn.fragments.teacher

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.ClassAdapter
import com.sdei.parentIn.dialog.TeacherAddChildDialog
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.teacher.TeacherClassViewModel
import kotlinx.android.synthetic.main.fragment_class.*

/**
 * Fragment to show class list
 */
class TeacherClassFragment : BaseFragment<TeacherClassViewModel>(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnAddStuManually->{
                TeacherAddChildDialog(mContext, R.style.pullBottomfromTop,
                        R.layout.dialog_teacher_add_child){

                }.show()
            }
        }

    }

    var classList = ArrayList<ClassModel.DataBean>()
    lateinit var classAdapter: ClassAdapter
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

    }

    private fun setClassListAdapter() {
        rvTeacherClass.layoutManager = LinearLayoutManager(mContext)
        classAdapter = ClassAdapter(mContext,classList)
        rvTeacherClass.adapter = classAdapter

    }

    override fun initListeners() {
      //rvTeacherClass.addOnItemTouchListener()

        btnAddStuManually.setOnClickListener(this)
    }

}
