package com.android.advicezoid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.android.advicezoid.ui.theme.AdvicezoidTheme

class Favorite : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvicezoidTheme {
                FvComposable()
            }
        }
    }
}

@Composable
fun FvComposable() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "", Modifier.clickable(onClick = {context.startActivity(
                    Intent(context, MainActivity::class.java)
                )}),)
                Text(text = "Favorites Advice")
            }
        }
    ){}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    AdvicezoidTheme {
        FvComposable()
    }
}