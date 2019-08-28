package com.sdei.parentIn.fragments.teacher

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.ClassAdapter
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.viewModel.teacher.ClassViewModel
import kotlinx.android.synthetic.main.fragment_class.*

/**
 * Fragment to show class list
 */
class ClassFragment : BaseFragment<ClassViewModel>() {

    var classList = arrayListOf<String>()
    lateinit var classAdapter: ClassAdapter
    override val layoutId: Int
        get() = R.layout.fragment_class
    override val viewModel: ClassViewModel
        get() = ViewModelProviders.of(this).get(ClassViewModel::class.java)

    override fun onCreateStuff() {
        setClassListAdapter()

    }

    private fun setClassListAdapter() {
        rvTeacherClass.layoutManager = LinearLayoutManager(mContext)
        classAdapter = ClassAdapter(mContext,classList)
        rvTeacherClass.adapter = classAdapter

    }

    override fun initListeners() {

    }

}
