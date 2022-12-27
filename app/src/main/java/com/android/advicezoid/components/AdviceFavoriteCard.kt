package com.android.advicezoid.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.R
import com.android.advicezoid.copyAdvice
import com.android.advicezoid.repository.Slips
import com.android.advicezoid.viewmodel.AdviceViewModel

@Composable
fun AdviceFavoriteCard(
    viewModel: AdviceViewModel = hiltViewModel(),
    advices: Slips
) {
    val context = LocalContext.current
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
                ) {
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

                        Column() {
                            IconButton(
                                onClick = {
                                    //code for deleting each advice from Room
                                    //viewModel.openDialog.value = true
                                    viewModel.delete(item)

                                }

                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "delete btn",
                                    modifier = Modifier.graphicsLayer {
                                        scaleX = 1f
                                        scaleY = 1f
                                    },
                                    tint = MaterialTheme.colors.primary,
                                )
                            }

                            IconButton(
                                onClick = {
                                    //code for deleting each advice from Room
                                    //viewModel.openDialog.value = true
                                    viewModel.delete(item)

                                }

                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_sharp_content_copy_24),
                                    contentDescription = "delete btn",
                                    modifier = Modifier
                                        .graphicsLayer {
                                            scaleX = 1f
                                            scaleY = 1f
                                        }
                                        .clickable(onClick = {
                                            context.copyAdvice(item.advice)
                                            Toast
                                                .makeText(context, "saved Advice copied!", Toast.LENGTH_SHORT)
                                                .show()
                                        }),
                                    tint = MaterialTheme.colors.primary,
                                )
                            }
                        }

                    }


                }

            }
        }
    }



    }
