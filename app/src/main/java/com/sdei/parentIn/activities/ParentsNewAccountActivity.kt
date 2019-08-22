package com.sdei.parentIn.activities


import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.OptionDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.interfaces.UserModel
import com.sdei.parentIn.utils.DATA
import com.sdei.parentIn.utils.getGender
import com.sdei.parentIn.utils.getRelations
import com.sdei.parentIn.viewModel.ParentNewAccountViewModel
import kotlinx.android.synthetic.main.activity_parents_new_account.*

class ParentsNewAccountActivity : BaseActivity<ParentNewAccountViewModel>(), View.OnClickListener {

    override val layoutId: Int
        get() = R.layout.activity_parents_new_account
    override val viewModel: ParentNewAccountViewModel
        get() = ViewModelProviders.of(this).get(ParentNewAccountViewModel::class.java)
    override val context: Context
        get() = this@ParentsNewAccountActivity

    override fun onCreate() {

    }

    override fun initListeners() {
        edtGender.setOnClickListener(this)
        edtRelationshipChild.setOnClickListener(this)
        edtLevelOfEducation.setOnClickListener(this)
        edtNoOfStudent.setOnClickListener(this)
        btnFollow.setOnClickListener(this)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.edtGender -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getGender(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtRelationshipChild -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getRelations(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtLevelOfEducation -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getRelations(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.edtNoOfStudent -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getRelations(),
                        getString(R.string.select_gender),
                        InterfacesCall.Callback { pos ->
                            edtGender.setText(getGender()[pos].name.toString())
                        }).show()
            }

            R.id.btnFollow -> {
                val model = UserModel.DataBean("",
                        edtFirstName.text.toString(),
                        edtLastName.text.toString(),
                        edtFirstName.text.toString(),
                        edtFirstName.text.toString(),
                        edtFirstName.text.toString(),
                        true,
                        edtFirstName.text.toString(),
                        1,
                        edtFirstName.text.toString(),
                        edtFirstName.text.toString(),
                        1,
                        1,
                        edtFirstName.text.toString()
                )

                val intent = Intent(mContext, ParentAddChildActivity::class.java)
                intent.putExtra(DATA, model)
                startActivity(intent)
            }
            R.id.btnBack -> {
                finish()
            }
        }
    }

}
