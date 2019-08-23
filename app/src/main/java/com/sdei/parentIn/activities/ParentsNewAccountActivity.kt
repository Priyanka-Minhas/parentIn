package com.sdei.parentIn.activities
import android.content.Context
import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.sdei.parentIn.R
import com.sdei.parentIn.dialog.OptionDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.interfaces.UserModel
import com.sdei.parentIn.utils.*
import com.sdei.parentIn.viewModel.ParentNewAccountViewModel
import com.wajahatkarim3.easyvalidation.core.view_ktx.nonEmpty
import com.wajahatkarim3.easyvalidation.core.view_ktx.validEmail
import kotlinx.android.synthetic.main.activity_parents_new_account.*
import kotlinx.android.synthetic.main.activity_parents_new_account.btnBack
class ParentsNewAccountActivity : BaseActivity<ParentNewAccountViewModel>(), View.OnClickListener {

     var isSameAddressAsStudent :Boolean = true

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
        rgYesNo.setOnCheckedChangeListener { radioGroup, id ->
            when (id) {
                R.id.rbYes ->{
                    isSameAddressAsStudent = true
                }
                R.id.rbNo ->{
                    isSameAddressAsStudent = false
                }

            }
        }
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
                        getString(R.string.select_relation),
                        InterfacesCall.Callback { pos ->
                            edtRelationshipChild.setText(getRelations()[pos].name.toString())
                        }).show()
            }

            R.id.edtLevelOfEducation -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getLevelOfEducation(),
                        getString(R.string.select_level_of_education),
                        InterfacesCall.Callback { pos ->
                            edtLevelOfEducation.setText(getRelations()[pos].name.toString())
                        }).show()
            }

            R.id.edtNoOfStudent -> {
                OptionDialog(mContext, R.style.pullBottomfromTop, R.layout.dialog_options,
                        getNoOfStudents(),
                        getString(R.string.select_no_of_student),
                        InterfacesCall.Callback { pos ->
                            edtNoOfStudent.setText(getGender()[pos].name.toString())
                        }).show()
            }
            R.id.btnFollow -> {
               if(!edtFirstName.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorFirstName))
                }else if(!edtLastName.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorLastName))
                }else if(!edtEmailParent.validEmail()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorValidEmail))
                }else if(!edtPasswordParent.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorValidPassword))
                }else if(!edtConfPassParent.text.toString().equals(edtPasswordParent.text.toString())){
                    showAlertSnackBar(btnFollow, getString(R.string.errorConfirmPassword))
                }else if(!edtAddress.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorAddress))
                }else if(!edtGender.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorGender))
                }else if(!edtRelationshipChild.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorRelationship))
                }else if(!edtId.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorIdentification))
                }else if(rgYesNo.checkedRadioButtonId==-1){
                    showAlertSnackBar(btnFollow, getString(R.string.errorStudentAddress))
                }else if(!edtLevelOfEducation.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorLevelOfEducation))
                }else if(!edtNoOfStudent.nonEmpty()){
                    showAlertSnackBar(btnFollow, getString(R.string.errorNoOfSchools))
                }else{
                   val model = UserModel.DataBean("",
                           edtFirstName.text.toString(),
                           edtLastName.text.toString(),
                           "",
                           edtRelationshipChild.text.toString(),
                           edtAddress.text.toString(),
                           isSameAddressAsStudent,
                           edtLevelOfEducation.text.toString(),
                           1,
                           edtEmailParent.text.toString(),
                           edtPasswordParent.text.toString(),
                           1,
                           1,
                           ""

                   )

                   val intent = Intent(mContext, ParentAddChildActivity::class.java)
                   intent.putExtra(DATA, model)
                   startActivity(intent)
                }

            }
            R.id.btnBack -> {
                finish()
            }
        }
    }



}
