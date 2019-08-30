package com.sdei.parentIn.activities.teacher


import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.adapters.ViewPagerAdapter
import com.sdei.parentIn.fragments.parent.ParentMessagesFragment
import com.sdei.parentIn.fragments.teacher.TeacherClassFragment
import com.sdei.parentIn.viewModel.teacher.TeacherClassViewModel
import kotlinx.android.synthetic.main.activity_parent_landing.*

class TeacherLandingActivity : BaseActivity<TeacherClassViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_teacher_landing
    override val viewModel: TeacherClassViewModel
        get() = ViewModelProviders.of(this).get(TeacherClassViewModel::class.java)
    override val context: Context
        get() = this@TeacherLandingActivity

    override fun onCreate() {
        setUpViewPager()
        // add in tab layout
        tabs.setupWithViewPager(viewPager)
    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TeacherClassFragment.newInstance(), getString(R.string.Clase))
        adapter.addFragment(ParentMessagesFragment.newInstance(), getString(R.string.Mensajes))
        viewPager.adapter = adapter
    }

    override fun initListeners() {

    }
}

