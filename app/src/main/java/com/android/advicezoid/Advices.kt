package com.android.advicezoid

import com.google.gson.annotations.SerializedName

data class Advices(
    @SerializedName("slip" ) var slip : Slip? = Slip()
)
