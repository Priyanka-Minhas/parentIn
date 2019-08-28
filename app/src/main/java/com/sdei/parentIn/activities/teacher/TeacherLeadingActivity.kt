package com.sdei.parentIn.activities.teacher


import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.ViewPagerAdapter
import com.sdei.parentIn.fragments.parent.ParentMessageFragment
import com.sdei.parentIn.fragments.teacher.ClassFragment
import com.sdei.parentIn.viewModel.teacher.TeacherLeadingViewModel


import kotlinx.android.synthetic.main.activity_parent_landing.*

class TeacherLeadingActivity : BaseActivity<TeacherLeadingViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_teacher_landing
    override val viewModel: TeacherLeadingViewModel
        get() = ViewModelProviders.of(this).get(TeacherLeadingViewModel::class.java)
    override val context: Context
        get() = this@TeacherLeadingActivity

    override fun onCreate() {
        setUpViewPager()
        // add in tab layout
        tabs.setupWithViewPager(viewPager)
    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ClassFragment(),getString(R.string.Clase))
        adapter.addFragment(ParentMessageFragment(),getString(R.string.Mensajes))
        viewPager.adapter = adapter
    }

    override fun initListeners() {

    }


}
