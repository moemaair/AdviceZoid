package com.android.advicezoid.components

import DeleteIcon
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.repository.Slips
import com.android.advicezoid.viewmodel.AdviceViewModel

@Composable
fun AdviceFavoriteCard(
    viewModel: AdviceViewModel = hiltViewModel(),
    advices: Slips
) {
    LazyColumn{
        items(
            items = advices
        ){ item ->  // one item of advice


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
                                .padding(10.dp)
                                .fillMaxWidth(0.9f) ,
                            textAlign = TextAlign.Start,
                            overflow = TextOverflow.Clip,

                        )
                        IconButton(
                            onClick = {
                                //code for deleting each advice from Room
                                //viewModel.openDialog.value = true
                                viewModel.delete(item)

                            }

                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "delete btn",
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
