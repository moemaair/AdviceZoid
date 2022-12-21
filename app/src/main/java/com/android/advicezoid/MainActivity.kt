package com.android.advicezoid

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.android.advicezoid.destinations.FavDestination
import com.android.advicezoid.ui.theme.AdvicezoidTheme
import com.android.advicezoid.viewmodel.AdviceViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate
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
                    DestinationsNavHost(navGraph = NavGraphs.root)
                }
            }
        }
    }
}


@RootNavGraph(start = true) // sets this as the start destination of the default nav graph
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    val context = LocalContext.current
    val viewModel = AdviceViewModel()
    // calling the data from Api
    runBlocking {
        launch {
            viewModel.gettingData()
        }
    }
    Box(modifier = Modifier.fillMaxSize()){
       Image(painter = painterResource(id = R.drawable.pic),
           contentDescription = "app background",
           modifier = Modifier
               .fillMaxSize(),
           contentScale = ContentScale.Crop)

           Column( modifier = Modifier.fillMaxWidth() , horizontalAlignment = Alignment.CenterHorizontally) {
               Image(painter = painterResource(id = R.drawable.transparent_logo),
                   contentDescription = "logo", modifier = Modifier.size(120.dp), alignment = Alignment.Center)
           }

       Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           ) {

           Card(
               modifier = Modifier
                   .fillMaxWidth()
                   .padding(50.dp)
                   .height(40.dp),
               shape = RoundedCornerShape(10.dp),

               ) {
               Row(
                   modifier = Modifier
                       .fillMaxWidth()
                       .background(Color.White)
                       .padding(10.dp),
                   horizontalArrangement = Arrangement.SpaceBetween,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Text(text = "DAILY ADVICE",
                       modifier = Modifier,
                       color = Gray,
                       style = MaterialTheme.typography.h4,
                       fontSize = 14.sp,

                       )
                   Box(modifier = Modifier
                       .fillMaxHeight()
                       .width(2.dp)
                       .background(Color.Gray))

                   Text(
                       text = "FAVORITES",
                       color = Black,
                       style = MaterialTheme.typography.h4,
                       fontSize = 14.sp,
                       modifier = Modifier.clickable(onClick = {navigator.navigate(FavDestination)})
                   )
               }
           }

           // advice card
           Card(modifier = Modifier
               .size(400.dp)
               .padding(40.dp),
               shape = RoundedCornerShape(20.dp)

           ) {
               Column(modifier = Modifier
                   .fillMaxSize()
                   .background(color = Color.White),
                   verticalArrangement = Arrangement.SpaceBetween)
               {
                   Column( modifier = Modifier
                       .fillMaxWidth(), horizontalAlignment = Alignment.Start) {
                       Image(painter = painterResource(id = R.drawable.quote_vector),
                           contentDescription = "start top quote icon",
                           modifier = Modifier.rotate(180f)
                       )
                   }
                   //where advice text is
                   LazyColumn{
                       if(viewModel.data.value.slip?.advice?.isEmpty() == true){
                           item{
                               LinearProgressIndicator(
                                   modifier = Modifier
                                       .fillMaxSize()
                                       .wrapContentSize(align = Alignment.Center),
                                   color = Color(0XFF4BAD91),
                               )
                           }
                       }
                       item {
                           Column(modifier = Modifier
                               .fillMaxWidth()
                               .padding(5.dp),
                               horizontalAlignment = Alignment.CenterHorizontally) {
                               Text(text = viewModel.data.value.slip?.advice.toString(),
                                   color = Black,
                                   textAlign = TextAlign.Center,
                                   style = MaterialTheme.typography.body1)
                           }
                       }
                   }
                   Row( modifier = Modifier
                       .fillMaxWidth()
                       .padding(5.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                       FavoriteButton()
                       Image(painter = painterResource(id = R.drawable.quote_vector),
                           contentDescription = "start bottom quote icon"
                       )

                   }
               }

           }
           ShareAndCopyComposable(viewModel = AdviceViewModel(), state = viewModel.data )
       }
   }

}


@Destination
@Composable
fun Fav() {
    val no = MutableList<Int>(2){it}
    LazyColumn{
        items(no){
            Text(text = no.toString())
        }
    }
}

// like button component
@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xffE91E63),
) {

    var isFavorite by remember { mutableStateOf(false) }

    IconToggleButton(
        checked = isFavorite,
        onCheckedChange = {
            isFavorite = !isFavorite
        }
    ) {
        Icon(
            tint = color,
            modifier = modifier.graphicsLayer {
                scaleX = 1.3f
                scaleY = 1.3f
            },
            imageVector = (if (isFavorite) {
                Icons.Filled.Favorite
            } else {
                Icons.Default.FavoriteBorder
            }) as ImageVector,
            contentDescription = null
        )
    }

}
