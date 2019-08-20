package com.sdei.parentIn.model

import android.os.Parcel
import android.os.Parcelable

class OptionsModel(
        var id: Int,
        var name: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<OptionsModel> = object : Parcelable.Creator<OptionsModel> {
            override fun createFromParcel(source: Parcel): OptionsModel = OptionsModel(source)
            override fun newArray(size: Int): Array<OptionsModel?> = arrayOfNulls(size)
        }
    }
}