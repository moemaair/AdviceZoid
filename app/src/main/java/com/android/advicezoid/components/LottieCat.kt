package com.android.advicezoid
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*

@Composable
fun LottieCat(
) {
    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(LottieCompositionSpec.Asset("lottie/cat.json"))

    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
        speed = 1.0f
    )

    Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(0.dp, 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LottieAnimation(
            compositionResult.value,
            progress,
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Your favorite advices will be stored here" ,
            textAlign = TextAlign.Center,
            fontSize = 15.sp,
            color = Color.Gray
        )
    }


}

@Preview
@Composable
fun LottieCat1(modifier : Modifier = Modifier.fillMaxSize()) {
    LottieCat()
}