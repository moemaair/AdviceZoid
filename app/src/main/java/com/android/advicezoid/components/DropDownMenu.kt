
package com.android.advicezoid.components
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.viewmodel.AdviceViewModel
import com.ramcosta.composedestinations.annotation.Destination


@Destination
@Composable
fun FavoriteScreenDropdownMenu(
    viewModel: AdviceViewModel = hiltViewModel(),
   // options: (option: List<String>) -> Unit

) {
    var itemsDropDown = listOf("options", "nasra")
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    var ctx = LocalContext.current

        DropdownMenu(
            expanded = viewModel.expanded,
            onDismissRequest = {
                viewModel.expanded = true
            }) {

            itemsDropDown.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        viewModel.expanded = false
                        selectedIndex = index
                    }
                )
                {
                    Column() {
                        Text(text = s.toString())
                    }
                }
            }

        }

}
