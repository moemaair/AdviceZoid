package com.android.advicezoid.ui.theme

import android.graphics.Bitmap.Config
import android.view.Window
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.core.os.ConfigurationCompat
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
        fontSize = 17.sp,
    ),
    // heading on appbar
    h3 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
    fontFamily = font,
    fontWeight = FontWeight.Bold,
    fontSize = 21.sp
),
    subtitle1 = TextStyle(
    fontFamily = font,
    fontWeight = FontWeight.Normal,
    fontSize = 15.sp,
     textAlign = TextAlign.Center
    )




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
