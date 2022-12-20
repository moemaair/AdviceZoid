package com.android.advicezoid

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.advicezoid.ui.theme.AdvicezoidTheme

class About : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvicezoidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    AboutScreen()
                }
            }
        }
    }
}

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar( backgroundColor = Color.Transparent, elevation = 0.dp) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack, contentDescription = "",
                        Modifier.clickable(onClick = {
                            //context.startActivity(
                               // Intent(context, Favorite::class.java)
                            //)
                        }),
                    )
                    Text(
                        text = "About",
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()

                    )

            }
        }
    ){}
//    ){
//        //AboutApp()
//    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    AdvicezoidTheme {

    }
}