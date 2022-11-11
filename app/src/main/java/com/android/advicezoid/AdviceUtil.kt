package com.android.advicezoid

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.advicezoid.ui.theme.AdvicezoidTheme

@Composable
fun AdviceUtil() {

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
            Image(painter = painterResource(id = R.drawable.ic_sharp_share_24), contentDescription ="share button" )
            Box(modifier = Modifier.fillMaxHeight().width(2.dp).background(Color.Gray))
            Image(painter = painterResource(id = R.drawable.ic_sharp_content_copy_24), contentDescription ="copy button" )
        }



    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
        AdviceUtil()
}