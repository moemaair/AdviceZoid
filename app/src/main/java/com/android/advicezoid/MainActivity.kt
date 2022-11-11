package com.android.advicezoid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.advicezoid.model.Advices
import com.android.advicezoid.ui.theme.AdvicezoidTheme
import com.android.advicezoid.viewmodel.AdviceViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvicezoidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    AdviceList(viewModel = AdviceViewModel())
                }
            }
        }
    }
}
@SuppressLint("UnrememberedMutableState", "CoroutineCreationDuringComposition")
@Composable
fun AdviceList(viewModel: AdviceViewModel) {
    var state = viewModel.mutableState
    var context = LocalContext.current
    val TAG = "MainActivity"

    runBlocking {
        launch {
            viewModel.gettingData()
        }
    }
    AdviceOnscreen(state = state)
}
@Composable

fun AdviceOnscreen(state: MutableState<Advices>) {
   Box(modifier = Modifier.fillMaxSize()){
       Image(painter = painterResource(id = R.drawable.bg_cities),
           contentDescription = "app background",
           modifier = Modifier
               .fillMaxSize()
               .blur(2.dp),
           contentScale = ContentScale.Crop)

       Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           ) {
           Card(modifier = Modifier
               .size(400.dp)
               .padding(40.dp)
               .shadow(2.dp),
               shape = RoundedCornerShape(20.dp)

           ) {
               Column(modifier = Modifier
                   .fillMaxSize()
                   .background(color = Color.White),
                   verticalArrangement = Arrangement.SpaceBetween)
               {
                   Column( modifier = Modifier
                       .fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                       Image(painter = painterResource(id = R.drawable.quote_vector), contentDescription = "top quote icon")
                   }
                   Column(modifier = Modifier
                       .fillMaxWidth()
                       .padding(5.dp),
                       horizontalAlignment = Alignment.CenterHorizontally) {
                       Text(text = state.value.slip?.advice.toString(), color = Black, textAlign = TextAlign.Center, style = MaterialTheme.typography.body1)
                   }
                   Column( modifier = Modifier
                       .fillMaxWidth(), horizontalAlignment = Alignment.End) {
                       Image(painter = painterResource(id = R.drawable.quote_vector), contentDescription = "top quote icon")
                   }
               }

               //copy and share card

           }
           AdviceUtil()


       }
   }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdvicezoidTheme {

    }
}