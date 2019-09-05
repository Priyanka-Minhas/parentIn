package com.sdei.parentIn.activities

import android.content.Context
import android.content.Intent
import android.view.View
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.parent.ParentLandingActivity
import com.sdei.parentIn.activities.supervisor.SupervisorLoginActivity
import com.sdei.parentIn.activities.teacher.TeacherLandingActivity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.utils.connectedToInternet
import com.sdei.parentIn.utils.getAppPref
import com.sdei.parentIn.viewModel.WelcomeViewModel
import kotlinx.android.synthetic.main.activity_welcome.*

/**
 * Created by shubham on 14/08/19.
 */

class WelcomeActivity : BaseActivity<WelcomeViewModel>(), View.OnClickListener {
    override fun onClick(v: View?) {
        if(connectedToInternet(cdParent)) {
            when (v!!.id) {
                R.id.cdParent -> {
                    getStudentList(cdParent)
                    getAppPref().setInt(InterConst.ROLE_ID, InterConst.ROLE_PARENT)
                    val intent = Intent(mContext, LoginActivity::class.java)
                    startActivity(intent)
                }

                R.id.cdTeacher -> {
                    getStudentList(cdTeacher)
                    mViewModel!!.getSchoolList()
                    getAppPref().setInt(InterConst.ROLE_ID, InterConst.ROLE_TEACHER)
                    val intent = Intent(mContext, LoginActivity::class.java)
                    startActivity(intent)
                }

                R.id.btnAboutFamiliasIn -> {
                    getStudentList(cvSupervisor)
                    val intent = Intent(mContext, AboutActivity::class.java)
                    startActivity(intent)
                }

                R.id.cvSupervisor ->{
                     getStudentList(cvSupervisor)
                    getAppPref().setInt(InterConst.ROLE_ID, InterConst.ROLE_SUPERVISOR)
                    val intent = Intent(mContext, SupervisorLoginActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private fun getStudentList(view: CardView) {
        if(connectedToInternet(view)){
            mViewModel!!.getSchoolList()
        }
    }

    override val layoutId: Int
        get() = R.layout.activity_welcome

    override val viewModel: WelcomeViewModel
        get() = ViewModelProviders.of(this).get(WelcomeViewModel::class.java)

    override val context: Context
        get() = this@WelcomeActivity

    override fun onCreate() {
        if(!getAppPref().getString(InterConst.AUTH_TOKEN).isNullOrEmpty()){
           val intent = if (getAppPref().getInt(InterConst.ROLE_ID) == InterConst.ROLE_PARENT) {
                Intent(mContext, ParentLandingActivity::class.java)
            } else {
                Intent(mContext, TeacherLandingActivity::class.java)
            }
            startActivity(intent)
            finish()
        }
    }

    override fun initListeners() {
        cdParent.setOnClickListener(this)
        cdTeacher.setOnClickListener(this)
        btnAboutFamiliasIn.setOnClickListener(this)
        cvSupervisor.setOnClickListener(this)
    }

}
