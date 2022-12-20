package com.android.advicezoid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.advicezoid.R
import com.google.gson.annotations.SerializedName

@Entity(tableName = "advices_table")
data class Slip(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    //@SerializedName("id") var id: Int?,

    @ColumnInfo(name = "advice_column")
    @SerializedName("advice") var advice: String? = ""
)


