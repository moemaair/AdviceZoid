package com.android.advicezoid.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn

import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
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
                    .shadow(3.dp)
                    ) {
                    Text(text = item.advice, fontSize = 15.sp, modifier = Modifier
                        .fillMaxSize().padding(10.dp), textAlign = TextAlign.Start)
                }
            }


        }
    }

}