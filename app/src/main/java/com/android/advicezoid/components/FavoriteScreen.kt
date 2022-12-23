package com.android.advicezoid.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.advicezoid.destinations.HomeScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun Fav(navigator: DestinationsNavigator) {
    val context = LocalContext.current
    val list = listOf<String>("Delete All")
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Transparent,
                elevation = 0.dp
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back home"
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier.fillMaxWidth(),
                elevation = 0.dp
            ) {
                Row(
                    modifier = Modifier
                        .background(MaterialTheme.colors.primaryVariant)
                        .fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Home, contentDescription = "home")
                    }
                    IconButton(onClick = { }) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "home")
                    }


                }

            }
        }
    ) {

        Box(modifier = androidx.compose.ui.Modifier.padding(10.dp)) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp),
                shape = MaterialTheme.shapes.medium, backgroundColor = Color.Gray
            ) {
                // where advice text will be
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { navigator.navigate(HomeScreenDestination)}) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "back home",
                            tint = Red
                        )
                    }
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = com.android.advicezoid.R.drawable.ic_sharp_content_copy_24),
                            contentDescription = "copy text",
                            tint = Black
                        )
                    }
                }
            }
        }

    }


}

