package com.android.advicezoid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.advicezoid.Realm.AdviceDatabaseOperations
import com.android.advicezoid.model.Advices
import com.android.advicezoid.ui.theme.AdvicezoidTheme
import com.android.advicezoid.viewmodel.AdviceViewModel
import kotlinx.coroutines.GlobalScope
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
fun AdviceList(viewModel: AdviceViewModel = AdviceViewModel()) {
    var state = viewModel.data
    var context = LocalContext.current
    val TAG = "MainActivity"


   GlobalScope.launch {
       // coroutines within a coroutine scope
       runBlocking {
           launch {
               viewModel.gettingData()
           }
       }
   }

    AdviceOnscreen(state = state)
}
@Composable

fun AdviceOnscreen(state: MutableState<Advices>) {
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()){
       Image(painter = painterResource(id = R.drawable.pic),
           contentDescription = "app background",
           modifier = Modifier
               .fillMaxSize(),
           contentScale = ContentScale.Crop)
        //logo

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
                   Text(text = "FAVORITES",
                       modifier = Modifier.clickable(onClick = {context.startActivity(Intent(context, Favorite::class.java))}),
                       color = Black,
                       style = MaterialTheme.typography.h4,
                       fontSize = 14.sp,

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
                   Column(modifier = Modifier
                       .fillMaxWidth()
                       .padding(5.dp),
                       horizontalAlignment = Alignment.CenterHorizontally) {
                       Text(text = state.value.slip?.advice.toString(),
                           color = Black,
                           textAlign = TextAlign.Center,
                           style = MaterialTheme.typography.body1)
                   }
                   Row( modifier = Modifier
                       .fillMaxWidth()
                       .padding(5.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                       FavoriteButton()

//                       // like button not clicked
                       Image(painter = painterResource(id = R.drawable.quote_vector),
                           contentDescription = "start bottom quote icon",
                           modifier = Modifier.clickable (onClick = {

                           })
                       )

                   }
               }

           }
           //copy and share card(
           AdviceUtil(viewModel = AdviceViewModel(), state = state )
       }
   }

}

@Composable
fun FavoriteButton(
    modifier: Modifier = Modifier,
    color: Color = Color(0xffE91E63),
db:AdviceDatabaseOperations = AdviceDatabaseOperations()
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
                db.insertAdvice()
            } else {
                Icons.Default.FavoriteBorder
            }) as ImageVector,
            contentDescription = null
        )
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AdvicezoidTheme {
        AdviceList()
    }
}