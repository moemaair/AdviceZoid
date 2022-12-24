package com.android.advicezoid.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.android.advicezoid.R


val font = FontFamily(
    Font( R.font.metropolisregular,weight = FontWeight.Normal),
    //Font(R.font.dmserifdisplay_italic, weight = FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    ),
    h3 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp
    ),
    subtitle1 = TextStyle(
            fontFamily = font,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
        color = Color.Gray
)
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)