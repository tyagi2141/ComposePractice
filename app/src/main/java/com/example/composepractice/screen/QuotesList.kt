package com.example.composepractice.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun QuotesList(data: Array<Quotes>, onClick: (quotes:Quotes) -> Unit) {



    LazyColumn(content = {
        items(data) {
            QuotesListItem(quotes = it, onClick = onClick)
        }
    })
}