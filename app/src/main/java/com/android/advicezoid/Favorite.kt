package com.android.advicezoid

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            TopAppBar( backgroundColor = Color.Transparent, elevation = 0.dp) {

                Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "",
                        Modifier.clickable(onClick = {
                            context.startActivity(
                                Intent(context, MainActivity::class.java)
                            )
                        }),
                    )
                    Text(
                        text = "Favorites Advice",
                        textAlign = TextAlign.Center
                    )
                    Icon(imageVector = Icons.Default.Info, contentDescription = "", modifier = Modifier)
                }
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