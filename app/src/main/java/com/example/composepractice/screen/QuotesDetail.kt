package com.example.composepractice.screen

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuotesDetail(modifier: Modifier = Modifier, quotes: Quotes) {

    BackHandler {
        DataManager.switchPages(null)
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
            .fillMaxSize()
    ) {
        Card(modifier.padding(32.dp)) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(10.dp), verticalArrangement = Arrangement.Center
            ) {

                Log.e("jhbhjbjjk", "$quotes")
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "",
                    modifier
                        .size(80.dp)
                        .rotate(180f)
                )
                Text(
                    text = quotes.quote ?: "NA",
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )
                Spacer(modifier = modifier.height(10.dp))
                Text(
                    text = quotes.author ?: "NA",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Thin, fontSize = 25.sp
                )
            }
        }

    }
}


@Preview(showSystemUi = true)
@Composable
fun QuotesShow() {
    QuotesDetail(
        quotes =
        Quotes(
            quote = "Life isn’t about getting and having, it’s about giving and being.",
            author = "Kevin Kruse."
        )
    )
}
