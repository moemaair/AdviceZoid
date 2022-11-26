package com.android.advicezoid

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.advicezoid.ui.theme.AdvicezoidTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun AboutApp() {
    val linkToGithubRepo = "https://github.com/moemaair/AdviceZoid.git" // linkage to github
Column(modifier = Modifier
    .fillMaxSize()
    .padding(top = 100.dp),
    verticalArrangement = Arrangement.SpaceBetween

) {
   Column(modifier = Modifier
       .fillMaxWidth()) {
       Column() {
           Image(painter = painterResource(id = R.drawable.logo_app),
               contentDescription = null,
               modifier = Modifier
                   .size(100.dp)
                   .clip(RoundedCornerShape(30.dp))
                   .shadow(10.dp))
           Text(text = "Advicezoid", textAlign = TextAlign.Center)
           Text(text = "v1.0(1)", style = MaterialTheme.typography.subtitle1, textAlign = TextAlign.Center)
       }
       Column(modifier = Modifier.padding(horizontal = 10.dp),
       ) {
           Text(text = "ATTRIBUTIONS $ LICENCING",  fontSize = 14.sp)
           Text(text = "Licesed Under MIT licence")
           Text(text = "VISIT", fontSize = 14.sp)
           Text(text = linkToGithubRepo, style = MaterialTheme.typography.subtitle1) // text to github
       }
   }
    Text(text = "Made with ❤️ by Mohamed Ibrahim ", textAlign = TextAlign.Center, modifier = Modifier.fillMaxSize())



}


}

@Preview(showBackground = true)
@Composable
fun AboutAppCPrev() {
        AboutApp()
}