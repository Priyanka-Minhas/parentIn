package com.sdei.parentIn.utils

import android.content.Context
import com.sdei.parentIn.R
import com.sdei.parentIn.model.OptionsModel


fun Context.getGender(): ArrayList<OptionsModel> {
    val arrayList = ArrayList<OptionsModel>()
    arrayList.add(OptionsModel(0, this.getString(R.string.male)))
    arrayList.add(OptionsModel(1, this.getString(R.string.female)))
    return arrayList
}
