package com.example.composepractice.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun TestUI() {

    var state = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit) {
        for (i in 1..10) {
            delay(2000)
            state.value = i
        }
    }

    //produce state
    val produceValue = produceState(initialValue = 0) {
        for (i in 1..10) {
            delay(2000)
            value = i
        }
    }

    Column {
        Text(
            text = state.value.toString(),
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp
        )
        Text(
            text = "procuserState ${produceValue.value}",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 20.sp
        )
        Text(text = "Rahul.", style = MaterialTheme.typography.titleLarge, fontSize = 20.sp)
    }
}


@Composable
fun DriveState() {
    val multiple = remember {
        mutableStateOf(5)
    }
    val index =
        produceState(1) {
            repeat(9) {
                delay(2000)
                value += 1
            }
        }


    val combineState = remember {
        derivedStateOf {
            "${multiple.value} * ${index.value} = ${multiple.value * index.value}"
        }
    }

    Box(Modifier, contentAlignment = Alignment.Center) {
        Text(text = combineState.value, fontSize = 30.sp)
    }

}


@Composable
fun QuotesList() {


    Card(modifier = Modifier.clip(shape = RoundedCornerShape(10.dp))) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.Top) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "",
                modifier = Modifier
                    .size(90.dp)
                    .padding(10.dp)
            )

            Column(modifier = Modifier.weight(9f)) {
                Text(text = "Quotes", style = MaterialTheme.typography.titleMedium)

                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(Color.LightGray)
                )
                Text(
                    text = "author name",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Thin
                )
            }

        }

    }


}


@Preview(showSystemUi = true)
@Composable
fun showUi() {
    QuotesList()
}












