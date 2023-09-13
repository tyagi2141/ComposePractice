package com.example.composepractice.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun QuotesListItem(
    modifier: Modifier = Modifier,
    quotes: Quotes,
    onClick: (quotes: Quotes) -> Unit
) {

    Card(
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick(quotes) },
        elevation = cardElevation(14.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "",
                modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180f)
                    .padding(0.dp, 0.dp, 0.dp, 8.dp),
                colorFilter = ColorFilter.tint(Color.White),
                alignment = Alignment.Center,)

            Spacer(modifier = modifier.padding(4.dp))

            Column(modifier = modifier.weight(1f)) {
                Text(
                    text = quotes.quote ?: "NA",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = modifier.padding(0.dp, 0.dp, 0.dp, 8.dp)
                )
                Box(
                    modifier
                        .height(4.dp)
                        .width(150.dp)
                        .background(color = Color.LightGray)
                )
                Text(
                    text = quotes.author ?: "NA",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }

}


@Preview
@Composable
fun show() {
    QuotesListItem(
        quotes =
        Quotes(
            quote = "Life isn’t about getting and having, it’s about giving and being.",
            author = "Kevin Kruse."
        ), onClick = {}
    )
}

