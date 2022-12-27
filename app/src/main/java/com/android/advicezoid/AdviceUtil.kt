package com.android.advicezoid

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.android.advicezoid.model.Advices
import com.android.advicezoid.viewmodel.AdviceViewModel

// used to copy quote to clipboard
fun Context.copyAdvice(text: String) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText("label", text)
    clipboard.setPrimaryClip(clip)
    println(clipboard.setPrimaryClip(clip))
}


// used to share quote to other application
fun Context.shareToOthers(quote: String) {
    val intent = Intent(Intent.ACTION_SEND)
    intent.type = "text/plain"
    intent.putExtra(Intent.EXTRA_TEXT, quote)
    startActivity(Intent.createChooser(intent, "Share via"))
}

@Composable
fun ShareAndCopyComposable(viewModel: AdviceViewModel = hiltViewModel(), state: MutableState<Advices>) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp)
            .height(40.dp),
        shape = RoundedCornerShape(20.dp),) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.ic_sharp_share_24),
                contentDescription ="share button",
                    modifier = Modifier.clickable(onClick = {
                      context.shareToOthers(state.value.slip?.advice.toString())
                    })
            )
            Box(modifier = Modifier
                .fillMaxHeight()
                .width(2.dp)
                .background(Color.Gray))


            Image(painter = painterResource(id = R.drawable.ic_sharp_content_copy_24),
                contentDescription ="copy button",
                modifier = Modifier.clickable(onClick = {
                    context.copyAdvice(state.value.slip?.advice.toString())
                    Toast.makeText(context, "Copied to Clipboard!", Toast.LENGTH_SHORT).show()

                })
            )

        }



    }

}
