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

fun Context.getRelations(): ArrayList<OptionsModel> {
    val arrayList = ArrayList<OptionsModel>()
    arrayList.add(OptionsModel(0,this.getString(R.string.father))) //padre
    arrayList.add(OptionsModel(1,this.getString(R.string.mother))) //madre
    arrayList.add(OptionsModel(2,this.getString(R.string.guardian))) //guardián
    return arrayList
}

fun Context.getNoOfStudents(): ArrayList<OptionsModel> {
    val arrayList = ArrayList<OptionsModel>()
    arrayList.add(OptionsModel(0,"1"))
    arrayList.add(OptionsModel(1,"2"))
    arrayList.add(OptionsModel(2,"3"))
    arrayList.add(OptionsModel(3,"4"))
    arrayList.add(OptionsModel(4,"5"))
    arrayList.add(OptionsModel(5,"6"))
    arrayList.add(OptionsModel(6,"7"))
    arrayList.add(OptionsModel(7,"8"))
    arrayList.add(OptionsModel(8,"9"))
    arrayList.add(OptionsModel(9,"10"))
    return arrayList
}

// Education Level
fun Context.getLevelOfEducation(): ArrayList<OptionsModel> {
    val arrayList = ArrayList<OptionsModel>()
    arrayList.add(OptionsModel(0,this.getString(R.string.doctorate)))
    arrayList.add(OptionsModel(1,this.getString(R.string.Masters)))
    arrayList.add(OptionsModel(2,this.getString(R.string.Bachelor)))
    arrayList.add(OptionsModel(3,this.getString(R.string.Under_Graduate)))
    return arrayList
}



// Locale key constant for
// English = "en"
// Spanish = "es"
 const val LOCALE_KEY = "en"

