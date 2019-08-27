package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.adapters.ViewPagerAdapter
import com.sdei.parentIn.fragments.ChildrenFragment
import com.sdei.parentIn.fragments.MessageFragment
import com.sdei.parentIn.viewModel.BaseViewModel
import kotlinx.android.synthetic.main.activity_landing.*

class LandingActivity : BaseActivity<BaseViewModel>(){

    override val layoutId: Int
        get() = R.layout.activity_landing

    override val viewModel: BaseViewModel
        get() = ViewModelProviders.of(this).get(BaseViewModel::class.java)

    override val context: Context
        get() = this@LandingActivity

    override fun onCreate() {
        setUpViewPager()
        // add in tab layout
        tabs.setupWithViewPager(viewPager)

    }

    private fun setUpViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ChildrenFragment(),getString(R.string.children))
        adapter.addFragment(MessageFragment(),getString(R.string.Mensajes))
        viewPager.adapter = adapter
    }

    override fun initListeners() {

    }


}
