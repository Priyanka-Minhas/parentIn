package com.sdei.parentIn.utils

import android.content.Context
import android.net.ParseException
import com.sdei.parentIn.R
import com.sdei.parentIn.model.OptionsModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList








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

fun  Context.getFormatDate(timeStamp:String) : String{
    //2019-09-06T06:13:02.224Z
    //yyyy-MM-dd'T'HH:mm:ss.SSSZ
    val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
        input.timeZone = TimeZone.getTimeZone("UTC")
    val output = SimpleDateFormat("dd/MM/yy")
    try{
        val date = input.parse(timeStamp)
        return output.format(date)
    }catch (P: ParseException){
        return ""
    }
}


// Locale key constant for
// English = "en"
// Spanish = "es"
 const val LOCALE_KEY = "en"

// spanish --> es-UY
// english --> en-US
 const val NETWORK_LOCALE_KEY = "en-US"
// camera request code

const val TAKE_PICTURE = 1


