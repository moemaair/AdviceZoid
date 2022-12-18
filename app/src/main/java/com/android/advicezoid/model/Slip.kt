package com.android.advicezoid.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.util.Objects

@Entity(tableName = "advices_table")
data class Slip(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("advice") var advice : String? = ""

)