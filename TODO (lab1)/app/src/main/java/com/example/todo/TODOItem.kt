package com.example.todo

import android.os.Parcel
import android.os.Parcelable

data class TODOItem(val id: Int?): Parcelable {
    var title: String? = null
    var status: Boolean = false
    var category: String? = null

    constructor(parcel: Parcel) : this(parcel.readValue(Int::class.java.classLoader) as? Int) {
        title = parcel.readString()
        status = parcel.readByte() != 0.toByte()
        category = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(title)
        parcel.writeByte(if (status) 1 else 0)
        parcel.writeString(category)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TODOItem> {
        override fun createFromParcel(parcel: Parcel): TODOItem {
            return TODOItem(parcel)
        }

        override fun newArray(size: Int): Array<TODOItem?> {
            return arrayOfNulls(size)
        }
    }
}
