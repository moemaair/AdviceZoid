
package com.android.advicezoid.components
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.viewmodel.AdviceViewModel


@Composable
fun FavoriteScreenDropdownMenu(
    viewModel: AdviceViewModel = hiltViewModel(),

) {
    var itemsDropDown = listOf("Delete All")
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    var ctx = LocalContext.current

    Box() {
        TextButton(onClick = { viewModel.expanded = true }) {
            Row() {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dop Down",
                    tint = Color.Gray
                )
            }

        }
        DropdownMenu(
            expanded = viewModel.expanded,
            onDismissRequest = {
                viewModel.expanded = false
            }) {
            itemsDropDown.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        viewModel.expanded = false
                        selectedIndex = index

                        if(s == "Delete All"){
                           viewModel.deleteAll()
                        }
                    }
                )
                {
                    Column() {
                        Text(text = s)
                    }
                }
            }

        }
    }

}
