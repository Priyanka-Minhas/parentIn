package com.sdei.parentIn.activities.supervisor

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.activities.SettingsActivity
import com.sdei.parentIn.adapters.ViewPagerAdapter
import com.sdei.parentIn.fragments.supervisor.SupervisorListFragment
import com.sdei.parentIn.fragments.supervisor.SupervisorMapFragment
import com.sdei.parentIn.fragments.teacher.TeacherClassFragment
import com.sdei.parentIn.fragments.teacher.TeacherMessageFragment
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_parent_landing.*

class SupervisorLeadingActivity : BaseActivity<BaseViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_teacher_landing
    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)
    override val context: Context
        get() = this@SupervisorLeadingActivity

    override fun onCreate() {
        setUpViewPager()
        // add in tab layout
        tabs.setupWithViewPager(viewPager)
        imgSetting.setOnClickListener {
           // val intent = Intent(context, SettingsActivity::class.java)
            //startActivity(intent)
        }
    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(TeacherMessageFragment.newInstance(), getString(R.string.Mensajes))
        adapter.addFragment(SupervisorListFragment.newInstance(),getString(R.string.list))
        adapter.addFragment(SupervisorMapFragment.newInstance(),getString(R.string.map))
        viewPager.adapter = adapter
    }

    override fun initListeners() {

    }
}
