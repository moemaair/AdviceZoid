package com.android.advicezoid.model

import com.google.gson.annotations.SerializedName
import java.util.Objects


data class Slip(
    @SerializedName("id"     ) var id     : Int?    = null,
    @SerializedName("advice" ) var advice : String? = "Loading..."

)