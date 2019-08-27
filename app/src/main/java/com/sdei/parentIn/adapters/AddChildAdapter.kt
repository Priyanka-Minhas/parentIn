package com.sdei.parentIn.adapters

import android.app.DatePickerDialog
import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.parent.ParentAddChildActivity
import com.sdei.parentIn.dialog.OptionDialog
import com.sdei.parentIn.interfaces.InterfacesCall
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.utils.getGender
import com.sdei.parentIn.utils.showAlertSnackBar
import kotlinx.android.synthetic.main.item_add_child.view.*
import java.util.*


class AddChildAdapter(var con: Context,
                      var mData: ArrayList<UserModel.ChildsBean>,
                      var mClick: ClickInterface) : RecyclerView.Adapter<AddChildAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_add_child, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtTitle.text = "${con.getString(R.string.nino) + " "}${position + 1}"

        if (position == 0) {
            holder.imgDelete.visibility = View.GONE
        }

        holder.imgDelete.setOnClickListener {
            mClick.deleteChild(position)
        }

        holder.gender.setOnClickListener {
            OptionDialog(con, R.style.pullBottomfromTop, R.layout.dialog_options,
                    con.getGender(),
                    con.getString(R.string.select_gender),
                    InterfacesCall.Callback { pos ->
                        holder.gender.setText(con.getGender()[pos].name.toString())
                        mData[position].gender = holder.gender.text.toString()

                    }).show()
        }

        holder.birthdate.setOnClickListener {
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            val dpd = DatePickerDialog(con, DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->

                // Display Selected date in Toast
                val date = "$year/${monthOfYear + 1}/$dayOfMonth"
                holder.birthdate.setText(date)
                mData[position].birthDate = holder.birthdate.text.toString()
                //showAlertSnackBar(txtCreateAccount, getString(R.string.errorChild))

            }, year, month, day)

            dpd.show()
        }

        holder.school.setOnClickListener {
            (con as ParentAddChildActivity).getSchoolList {

                holder.teacher.setText("")
                mData[position].teacher = ""

                holder.school.setText(it.schoolName.toString())
                holder.school.text.toString()
                mData[position].school = it._id
            }
        }

        holder.teacher.setOnClickListener {
            if (TextUtils.isEmpty(holder.school.text.toString())) {
                val p = position + 1
                showAlertSnackBar(holder.teacher, con.getString(R.string.errorSchool) + " " + p)
                return@setOnClickListener
            }
            (con as ParentAddChildActivity).getTeacherList(mData[position].school) {
                holder.teacher.setText(it.firstName.toString())
                mData[position].teacher = it._id
            }
        }

        holder.firstName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                mData[position].firstName = holder.firstName.text.toString()
            }
        })

        holder.lastName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                mData[position].lastName = holder.lastName.text.toString()

            }
        })

        holder.identityCard.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                mData[position].verificationCard = holder.identityCard.text.toString()
            }
        })

    }


    override fun getItemCount(): Int {
        return mData.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgDelete = itemView.imgDelete!!
        var txtTitle = itemView.txtTitle!!
        var firstName = itemView.edtChildFirstName!!
        var lastName = itemView.edtChildLastName!!
        var identityCard = itemView.edtChildIdentityCard!!
        var gender = itemView.edtChildGender!!
        var birthdate = itemView.edtChildBirthDate!!
        var school = itemView.edtChildSchool!!
        var teacher = itemView.edtChildTeacher!!
    }

    interface ClickInterface {
        fun deleteChild(pos: Int)
    }

}


