package com.android.advicezoid.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun NavigationComposable() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Favorite
    )

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
            .height(40.dp),
        shape = RoundedCornerShape(20.dp),

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            items.forEach { it ->
             Text(text = it.text)

            }

        }



    }


}