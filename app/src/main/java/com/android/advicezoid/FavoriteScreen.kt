package com.android.advicezoid.components


import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.LottieCat
import com.android.advicezoid.destinations.HomeScreenDestination
import com.android.advicezoid.viewmodel.AdviceViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination()
@Composable
fun Fav(
    navigator: DestinationsNavigator,
    viewModel: AdviceViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val advices by viewModel.advices.collectAsState(
        initial = emptyList()
    )
    var selectedIndex by remember {
        mutableStateOf(0)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Transparent,
                elevation = 0.dp,

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navigator.navigate(HomeScreenDestination)}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "back home"
                        )
                    }
                    Text(text = "Favorites" , fontSize = 16.sp,
                        style = MaterialTheme.typography.h3,
                        color = if(isSystemInDarkTheme()) Color.Gray else  Color.Black
                    )

                    // call our dropdown here
                    FavoriteScreenDropdownMenu()

                }
            }
        },
        content = {
            if(advices.isNotEmpty()){
                AdviceFavoriteCard(
                    advices = advices,
                )
                //now the opendialog is true
            }
            else {
                LottieCat()
            }
            DialogBoxForSavedAdvice(

            )

        },
        bottomBar = {
            BottomNav(navigator = navigator)
        }
    )


}

