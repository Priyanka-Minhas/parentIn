package com.sdei.parentIn.activities.teacher

import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.fragments.BaseFragment
import com.sdei.parentIn.viewModel.teacher.ClassViewModel

/**
 * Fragment to show class list
 */
class ClassFragment : BaseFragment<ClassViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_class
    override val viewModel: ClassViewModel
        get() = ViewModelProviders.of(this).get(ClassViewModel::class.java)

    override fun onCreateStuff() {

    }

    override fun initListeners() {

    }


}
