package com.android.advicezoid.components

import androidx.compose.animation.AnimatedContentScope.SlideDirection.Companion.End
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.advicezoid.repository.Slips

@Composable
fun AdviceFavoriteCard(advices: Slips) {

    LazyColumn{
        items(items = advices ){
           item ->
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(10.dp, 0.dp)

            ){
                Card(modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)
                    .shadow(3.dp)) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item.advice, fontSize = 17.sp,
                            modifier = Modifier
                            .padding(10.dp).fillMaxWidth(0.9f ) ,
                            textAlign = TextAlign.Start,
                            overflow = TextOverflow.Clip,

                        )

                        IconButton(
                            onClick = {
                                //code for deleting each advice from Room
                            }

                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "heart icon",
                                modifier = Modifier.graphicsLayer {
                                    scaleX = 0.8f
                                    scaleY = 0.8f
                                },
                                tint = Color.Gray,
                            )
                        }

                    }


                    }

                }
            }
        }



    }
