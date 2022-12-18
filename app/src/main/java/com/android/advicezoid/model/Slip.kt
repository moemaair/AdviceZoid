package com.android.advicezoid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.Objects

@Entity(tableName = "advices_table")
data class Slip(
    @ColumnInfo(name = "id")
    @SerializedName("id") var id: Int? = null,

    @ColumnInfo(name = "advice")
    @SerializedName("advice") var advice : String? = ""

)