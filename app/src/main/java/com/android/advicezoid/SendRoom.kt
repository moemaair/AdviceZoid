package com.android.advicezoid

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.model.Slip
import com.android.advicezoid.viewmodel.AdviceViewModel

@Composable
fun Send(addAdvice: (advice: Slip)  -> Unit) {
    var state by remember{ mutableStateOf("") }
    Column() {
        TextField(value = state ,
            onValueChange = { state = it} ,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        OutlinedButton(
            onClick = {
                val advice = Slip(0,state)
                addAdvice(advice)
            }
        )
        {
            Text(text = "insert")

        }

    }
}