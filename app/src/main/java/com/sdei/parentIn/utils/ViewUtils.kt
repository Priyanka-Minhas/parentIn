package com.sdei.parentIn.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.sdei.parentIn.R
import com.sdei.parentIn.utils.InterConstants.CODE_SUCCESS

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
            showToast(message)
            false
        }
    }
}

fun Context.getUtils(): Utils {
    return Utils(this)
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
