package com.android.advicezoid

import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.core.graphics.alpha
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.components.Fav
import com.android.advicezoid.destinations.FavDestination
import com.android.advicezoid.model.Slip
import com.android.advicezoid.ui.theme.AdvicezoidTheme
import com.android.advicezoid.viewmodel.AdviceViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private lateinit var gettingData: Unit

@AndroidEntryPoint
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



@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen( viewModel: AdviceViewModel = hiltViewModel(),navigator: DestinationsNavigator) {
    val context = LocalContext.current
    gettingData = viewModel.gettingData(context)
    runBlocking {
            launch {
                gettingData

            }
    }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.pic),
                contentDescription = "app background",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.size(100.dp))
            }

            Column(
                modifier = Modifier.fillMaxSize(),
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
                        Text(
                            text = "DAILY ADVICE",
                            modifier = Modifier,
                            color = Gray,
                            style = MaterialTheme.typography.h4,
                            fontSize = 14.sp,

                            )
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(2.dp)
                                .background(Color.Gray)
                        )

                        Text(
                            text = "FAVORITES",
                            color = Black,
                            style = MaterialTheme.typography.h4,
                            fontSize = 14.sp,
                            modifier = Modifier.clickable(onClick = {
                                // to favorite screen
                                navigator.navigate(FavDestination)

                            })
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .size(400.dp)
                        .padding(40.dp),
                    shape = RoundedCornerShape(20.dp)

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color.White),
                        verticalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(), horizontalAlignment = Alignment.Start
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.quote_vector),
                                contentDescription = "start top quote icon",
                                modifier = Modifier.rotate(180f)
                            )
                        }
                        //where advice text is
                        LazyColumn {
                            if (viewModel.data.value.slip?.advice?.isEmpty() == true) {
                                item {
                                    LinearProgressIndicator(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .wrapContentSize(align = Alignment.Center),
                                        color = Color(0XFF4BAD91),
                                    )
                                }
                            }
                            item {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = viewModel.data.value.slip?.advice.toString(),
                                        color = Black,
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.body1
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            FavoriteButton(
                                modifier = Modifier,
                                Color(0xffE91E63),
                                viewModel = viewModel,
                                takeAdvice = {
                                        advice ->
                                    var dt = viewModel.data.value.slip?.advice.toString()
                                    advice.advice = dt
                                    viewModel.addAdvice(advice)
                                }
                            )
                            Image(
                                painter = painterResource(id = R.drawable.quote_vector),
                                contentDescription = "start bottom quote icon"
                            )

                        }
                    }

                }
                ShareAndCopyComposable( state = viewModel.data )

            }
        }

    }


@Composable
fun FavoriteButton(
    modifier: Modifier,
    color: Color,
    viewModel: AdviceViewModel,
    takeAdvice: (advice: Slip) -> Unit
) {

        val advice = Slip(0, "")
        val ctx = LocalContext.current

        var imageVector: ImageVector by remember {
                mutableStateOf(Icons.Default.FavoriteBorder)
        }
        IconToggleButton(
            checked = viewModel.isFavorite,
            onCheckedChange = {
                viewModel.isFavorite = !viewModel.isFavorite
            }
        ) {
            //!isFavorite means not clicked
            Icon(
                imageVector = imageVector,
                contentDescription = "heart icon",
                modifier = modifier
                    .graphicsLayer {
                        scaleX = 1.3f
                        scaleY = 1.3f
                    }
                    .clickable {
                        if (!viewModel.isFavorite) {
                            takeAdvice(advice)  // sending data to a fava page
                            imageVector = Icons.Default.Favorite

                        } else {
                            println("No data! sorry")
                        }
                    },
                tint = color,
                )

//            Icon(
//                tint = color,
//                modifier = modifier.graphicsLayer {
//                        scaleX = 1.3f
//                        scaleY = 1.3f
//                    }.clickable(onClick = {
//                        if (!isFavorite) takeAdvice(advice) else println("No data! sorry")
//                    }),
//                imageVector = if (!isFavorite) Icons.Default.FavoriteBorder else Icons.Filled.Favorite
//            )
        }

}

