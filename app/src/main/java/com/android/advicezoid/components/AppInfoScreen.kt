package com.android.advicezoid.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.sharp.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.advicezoid.destinations.AppInfoScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun AppInfoScreen(
    navigator: DestinationsNavigator
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(15.dp, 0.dp),
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
            ) {
                Text(text = "About Us",
                    style = MaterialTheme.typography.h3,
                    color = if(isSystemInDarkTheme()) Color.Gray else  Color.Black

                )
            }
        },
        content = {padding ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 40.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Advicezoid",
                        style = MaterialTheme.typography.h4,
                    )
                    Text(text = "Version 1.0.0",
                        style = MaterialTheme.typography.body1,
                    )
                }

                Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 40.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Developer",
                        style = MaterialTheme.typography.h4,
                    )
                    Text(text = "Mohamed Ibrahim",
                        style = MaterialTheme.typography.body1,
                    )
                }

                Column(modifier = Modifier.fillMaxWidth().padding(0.dp, 40.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Contact us",
                        style = MaterialTheme.typography.h3,
                    )
                    Text(text = "advicezoid@gmail.com",
                        style = MaterialTheme.typography.body1

                    )
                }
            }


        },
        bottomBar = {
            BottomNav(navigator = navigator)
        }

    )
}