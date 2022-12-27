package com.android.advicezoid.components

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.advicezoid.destinations.SettingScreenDestination
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
                backgroundColor = Color.Transparent,
                elevation =0.dp,

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navigator.navigate(SettingScreenDestination)}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back home"
                        )
                    }
                    Text(text = "About Us",
                        style = MaterialTheme.typography.h3,
                        color = if(isSystemInDarkTheme()) Color.Gray else  Color.Black

                    )
                    Spacer(modifier = Modifier.size(50.dp))
                }
            }
        },
        content = {padding ->
            Column(
                modifier = Modifier.fillMaxSize().padding(0.dp, 40.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Advicezoid",
                        style = MaterialTheme.typography.h4,
                    )
                    Text(text = "Version 1.0.0",
                        style = MaterialTheme.typography.body1,
                         color = Color.Gray
                    )
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Developer",
                        style = MaterialTheme.typography.h4,
                    )
                    Text(text = "Mohamed Ibrahim",
                        style = MaterialTheme.typography.body1,
                         color = Color.Gray
                    )
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 30.dp),
                 horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                    Text(text = "Contact us",
                        style = MaterialTheme.typography.h3,
                    )
                    Text(text = "advicezoid@gmail.com",
                        style = MaterialTheme.typography.body1,
                        color = Color.Gray

                    )
                }
            }


        },
        bottomBar = {
            BottomNav(navigator = navigator)
        }

    )
}