package com.sdei.parentIn.fragments.teacher

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.ClassAdapter
import com.sdei.parentIn.adapters.MessagesAdapter
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.model.ClassModel
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.utils.responseHandler
import com.sdei.parentIn.utils.showProgess
import com.sdei.parentIn.viewModel.teacher.ClassViewModel
import com.sdei.parentIn.viewModel.teacher.TeacherLeadingViewModel
import kotlinx.android.synthetic.main.fragment_class.*
import kotlinx.android.synthetic.main.fragment_message.*

/**
 * Fragment to show class list
 */
class ClassFragment : BaseFragment<TeacherLeadingViewModel>() {

    var classList = ArrayList<ClassModel.DataBean>()
    lateinit var classAdapter: ClassAdapter
    override val layoutId: Int
        get() = R.layout.fragment_class
    override val viewModel: TeacherLeadingViewModel
        get() = ViewModelProviders.of(this).get(TeacherLeadingViewModel::class.java)

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

    }


}
