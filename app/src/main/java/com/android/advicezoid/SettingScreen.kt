package com.android.advicezoid

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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


@Destination
@Composable
fun SettingScreen(
    navigator: DestinationsNavigator
) {

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(15.dp, 0.dp),
                backgroundColor = Color.Transparent,
                elevation = 0.dp,
                ) {
                Text(text = "Setting",
                    style = MaterialTheme.typography.h3,
                    color = if(isSystemInDarkTheme()) Color.Gray else  Color.Black

                )
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(15.dp, 20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)

            ) {
                // take me to App info screen
               TextButton(modifier = Modifier
                   .fillMaxWidth()
                   .background(Color.Transparent)
                   .padding(0.dp),
                   colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                   onClick = { navigator.navigate(AppInfoScreenDestination) },
                   ) {  // take me to app info screen
                        Row(modifier = Modifier.fillMaxWidth()) {
                            IconButton(onClick = { navigator.navigate(AppInfoScreenDestination) }) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "info about app",
                                    modifier = Modifier
                                        .graphicsLayer {
                                            scaleX = 1.6F
                                            scaleY = 1.6F
                                        }
                                        .padding(0.dp, 0.dp, 5.dp, 0.dp)
                                )
                            }
                            Column() {
                                Text(text = "App info", style = MaterialTheme.typography.h3)
                                Text(text = "Learn More about Advicezoid",
                                    style = MaterialTheme.typography.body1,
                                    color = if(isSystemInDarkTheme()) Color.White else Color.Gray
                                )
                            }
                        }
                    }
                // take me to email to report an issue : Emailing
                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = { },
                ) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        ) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = if(isSystemInDarkTheme()) R.drawable.bug_report_dark else R.drawable.bug_report_light),
                                contentDescription = "Report A Trouble/Issue",
                                modifier = Modifier
                                    .graphicsLayer {
                                        scaleX = 1.6F
                                        scaleY = 1.6F
                                    }
                                    .padding(0.dp, 0.dp, 5.dp, 0.dp)
                            )
                        }
                        Column() {
                            Text(text = "Report A Trouble/Issue", style = MaterialTheme.typography.h3)
                            Text(text = "Tell us what happened - the more detail the better!",
                                style = MaterialTheme.typography.body1,
                                color = if(isSystemInDarkTheme()) Color.White else Color.Gray
                            )
                        }
                    }
                }
                // Take me to play store: Start rates
                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = { },
                ) {  // take me to app info screen
                    Row(modifier = Modifier.fillMaxWidth()) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Star,
                                contentDescription = "Rate Our App",
                                modifier = Modifier
                                    .graphicsLayer {
                                        scaleX = 1.6F
                                        scaleY = 1.6F
                                    }
                                    .padding(0.dp, 0.dp, 5.dp, 0.dp)
                            )
                        }
                        Column() {
                            Text(text = "Rate Our App", style = MaterialTheme.typography.h3)
                            Text(text = "Leave a review if you loved Advicezoid",
                                style = MaterialTheme.typography.body1,
                                color = if(isSystemInDarkTheme()) Color.White else Color.Gray
                            )
                        }
                    }
                }
                //take me to other users : Share app

                TextButton(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
                    onClick = { },
                ) {  // take me to app info screen
                    Row(modifier = Modifier.fillMaxWidth()) {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Sharp.Share,
                                contentDescription = "Share Our App",
                                modifier = Modifier
                                    .graphicsLayer {
                                        scaleX = 1.6F
                                        scaleY = 1.6F
                                    }
                                    .padding(0.dp, 0.dp, 5.dp, 0.dp)
                            )
                        }
                        Column() {
                            Text(text = "Share Our App", style = MaterialTheme.typography.h3)
                            Text(text = "Help others discover the power of advicezoid",
                                style = MaterialTheme.typography.body1,
                                color = if(isSystemInDarkTheme()) Color.White else Color.Gray
                            )
                        }
                    }
                }

            }


        }

    )

}

