package com.sdei.parentIn.utils

import android.content.Context
import com.sdei.parentIn.R
import com.sdei.parentIn.model.OptionsModel

var CODE_SUCCESS = 200
var CODE_ERROR = 404
var CODE_WARNING = 303

var DATA = "data"

fun Context.getGender(): ArrayList<OptionsModel> {
    val arrayList = ArrayList<OptionsModel>()
    arrayList.add(OptionsModel(0, this.getString(R.string.male)))
    arrayList.add(OptionsModel(1, this.getString(R.string.female)))
    return arrayList
}

fun Context.getRelations(): ArrayList<OptionsModel> {
    val arrayList = ArrayList<OptionsModel>()
    arrayList.add(OptionsModel(0,this.getString(R.string.father))) //padre
    arrayList.add(OptionsModel(1,this.getString(R.string.mother))) //madre
    arrayList.add(OptionsModel(1,this.getString(R.string.guardian))) //guardián
    return arrayList
}
