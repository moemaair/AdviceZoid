package com.android.advicezoid.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.advicezoid.destinations.HomeScreenDestination
import com.android.advicezoid.destinations.SettingScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun BottomNav(navigator: DestinationsNavigator) {
    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colors.primaryVariant)
                .fillMaxSize(), horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { navigator.navigate(HomeScreenDestination)}) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(imageVector = Icons.Default.Home, contentDescription = "home")
                    Text(text = "Home", style = MaterialTheme.typography.subtitle1)
                }
            }
            IconButton(onClick = { navigator.navigate(SettingScreenDestination)}) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "home")
                    Text(text = "Setting", style = MaterialTheme.typography.subtitle1)
                }
            }


        }

    }
}