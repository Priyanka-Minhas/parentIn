package com.sdei.parentIn.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.sdei.parentIn.AppApplication
import com.sdei.parentIn.R
import com.sdei.parentIn.activities.WelcomeActivity
import com.sdei.parentIn.interfaces.InterConst
import com.sdei.parentIn.interfaces.InterConst.CODE_SESSION_EXPIRED
import com.sdei.parentIn.interfaces.InterConst.CODE_SUCCESS
import com.sdei.parentIn.model.UserModel
import com.sdei.parentIn.room.RoomDb
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.json.JSONObject
import java.io.File



/**
 * Created by shubham on 12/06/19.
 */

fun Context.showToast(text: String?, duration: Int = Toast.LENGTH_SHORT) {
    text?.let { Toast.makeText(this, it, duration).show() }
}

fun EditText.toStringOrNull(): String? {
    val str = toString()
    return if (str.isEmpty()) null else str
}

fun Context.showProgess() {
    LoadingDialog.getLoader().showLoader(this)
}

fun Context.connectedToInternet(): Boolean {
    return ConnectionDetector(this).isConnectingToInternet
}

fun Context.connectedToInternet(view: View): Boolean {
    return if (ConnectionDetector(this).isConnectingToInternet) {
        true
    } else {
        showInternetAlert(view)
        false
    }
}

fun hideProgress() {
    LoadingDialog.getLoader().dismissLoader()
}

fun Context.responseHandler(statusCode: Int, message: String): Boolean {
    hideProgress()
    return when (statusCode) {
        CODE_SUCCESS -> true
        else -> {
            if (statusCode == CODE_SESSION_EXPIRED) {
//                logOut()
            }
            showToast(message)
            false
        }
    }
}

fun handleJson(response: String): Pair<String, String> {
    val obj = JSONObject(response)
    val statusCode = obj.getString("statusCode")
    val message = obj.getString("message")
    return Pair(statusCode, message)
}

fun Activity.logOut() {
    RoomDb.getInstance(application).getDao().deleteParentChildDb()
    RoomDb.getInstance(application).getDao().deleteSchoolDb()
    RoomDb.getInstance(application).getDao().deleteTeacherClassDb()
    getAppPref().clearShf()

    val intent = Intent(this, WelcomeActivity::class.java)
    startActivity(intent)
    finishAffinity()
}

fun getAppPref(): AppPreference {
    return AppPreference(AppApplication.getInstance())
}

fun saveUserData(model: UserModel.DataBean) {

    /**
     * _id : 5d5f7fb41c7e4c024e5a2c7c
     * firstName : Lucifer
     * lastName : Morningstar
     * phoneNumber : 8699826276
     * relationWithChild : Guardian
     * homeAddress : Top Floor, Lux, Los Angeles
     * isSameAddressAsStudent : true
     * levelOfEducation : PHD
     * noOfStudents : 1
     * emailAddress : abcde@gmail.com
     * password : $2b$12$P/jtXSrlmxIW7y1V1IL8x.1QYqNjCR8HW4wwX3Rwiks416UmucQ36
     * roleId : 2
     * childs : [{"_id":"5d5f7fb41c7e4c024e5a2c7d","firstName":"Demo","lastName":"Name","verificationCard":"45983434755","gender":"M","birthDate":"11-10-1991","school":"5d5e322baaa88c670cb0babb","teacher":"5d5e7f8a439fae1351a2914b"}]
     * __v : 0
     */
    getAppPref().setString(InterConst.USER_DATA, Gson().toJson(model))
    getAppPref().setString(InterConst.AUTH_TOKEN, model.token)
    getAppPref().setString(InterConst.ID, model._id)
    if (model.school != null) {
        getAppPref().setString(InterConst.STUDENT_ID, model.school)
    }
    getAppPref().setString(InterConst.FIRST_NAME, model.firstName)
    getAppPref().setString(InterConst.LAST_NAME, model.lastName)
}

fun getUserData(): UserModel.DataBean {
    return Gson().fromJson(getAppPref().getString(InterConst.USER_DATA, ""), UserModel.DataBean::class.java)
}


fun showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}

fun showAlertSnackBar(view: View, message: String) {
    val mSnackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
    mSnackbar.view.setBackgroundColor(Color.RED)
    mSnackbar.show()
}

fun showSucessSnackBar(view: View, message: String) {
    val mSnackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
    mSnackbar.view.setBackgroundColor(Color.GREEN)
    mSnackbar.show()
}

fun showInternetAlert(view: View) {
    Snackbar.make(view, R.string.errorInternet, Snackbar.LENGTH_SHORT).show()
}

fun ImageView.loadUserPhoto(photoUrl: String?) = ifNotDestroyed {
    Glide.with(this).load(photoUrl).fallback(R.drawable.ic_launcher_foreground).into(this)
}

fun ImageView.loadImage(image: String?) = ifNotDestroyed {
    Glide.with(this).load(image).centerCrop().into(this)
}

fun ImageView.loadImageOrHide(image: String?) =
        if (image != null) {
            visibility = View.VISIBLE
            loadImage(image)
        } else {
            visibility = View.GONE
        }


private fun View.ifNotDestroyed(block: () -> Unit) {
    if (!(context as Activity).isDestroyed) {
        block()
    }
}

 fun prepareMultiFilePart(mFile: File, field_name: String): MultipartBody.Part {
    val requestFile = RequestBody.create(MediaType.parse("image/*"), mFile)
    return MultipartBody.Part.createFormData(field_name, mFile.name, requestFile)
}

//fun prepareMultiPartLsit(value: ArrayList<String>, field_name: String): MultipartBody.Part{
//    val descriptionList = ArrayList<MultipartBody.Part>()
//    for(i in 0 until value.size) {
//        descriptionList.add()
//    }
//    return MultipartBody.Part.createFormData(field_name, value)
//}

fun createPartFromString(data: String): RequestBody {
    return RequestBody.create(MediaType.parse("text/plain"), data)
}


