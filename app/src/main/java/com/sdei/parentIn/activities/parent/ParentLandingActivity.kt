package com.sdei.parentIn.activities.parent

import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.BaseActivity
import com.sdei.parentIn.activities.SettingActivity
import com.sdei.parentIn.adapters.ViewPagerAdapter
import com.sdei.parentIn.fragments.parent.ParentChildrenFragment
import com.sdei.parentIn.fragments.parent.ParentMessagesFragment
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_parent_landing.*

class ParentLandingActivity : BaseActivity<BaseViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_parent_landing

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@ParentLandingActivity

    override fun onCreate() {
        setUpViewPager()
        tabs.setupWithViewPager(viewPager)
        imgSetting.setOnClickListener {
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ParentChildrenFragment.newInstance(), getString(R.string.children))
        adapter.addFragment(ParentMessagesFragment.newInstance(), getString(R.string.Mensajes))
        viewPager.adapter = adapter

    }

    override fun initListeners() {

    }

}
