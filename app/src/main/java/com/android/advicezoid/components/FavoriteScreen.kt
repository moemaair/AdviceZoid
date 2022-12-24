package com.android.advicezoid.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.viewmodel.AdviceViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun Fav(navigator: DestinationsNavigator, viewModel: AdviceViewModel = hiltViewModel()) {
    val context = LocalContext.current

    val advices by viewModel.advices.collectAsState(
        initial = emptyList()
    )

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
        content = {
            AdviceFavoriteCard(
                advices = advices
            )
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
    )


}
