package com.android.advicezoid.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.model.Slip
import com.android.advicezoid.viewmodel.AdviceViewModel

@Composable
fun DialogBoxForSavedAdvice(
    viewModel: AdviceViewModel = hiltViewModel() ,
    deleteAdvice : () -> Unit

) {
    if(viewModel.openDialog.value){
        AlertDialog(
            backgroundColor = Color.White,
            shape = MaterialTheme.shapes.large,
            onDismissRequest = { viewModel.openDialog.value = false },
            modifier = Modifier.padding(0.dp,0.dp,0.dp,10.dp),
            title = {
                Text(
                    text = "Are you sure you want to discard \n your saved Advice?",
                    textAlign = TextAlign.Center,
                    fontWeight = Bold,
                    fontSize = 17.sp,
                    lineHeight = 1.4.em
                )
            },

            confirmButton = {
                Button(
                    modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center),
                    shape = MaterialTheme.shapes.medium,
                    onClick = {
                        viewModel.openDialog.value = false

                    }) {
                    Text(text = "Yes, Discard", color = White,style = MaterialTheme.typography.h3, modifier = Modifier.padding(20.dp, 3.dp))
                }
            },
            dismissButton = {
                TextButton(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center),
                    onClick = { viewModel.openDialog.value = false }) {
                    Text(text = "Cancel", color = MaterialTheme.colors.primary,)
                }
            }
        )
    }
}