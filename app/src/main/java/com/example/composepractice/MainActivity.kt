package com.example.composepractice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.composepractice.screen.DataManager
import com.example.composepractice.screen.DataManager.loadJSONFromAsset
import com.example.composepractice.screen.DataManager.quotesList
import com.example.composepractice.screen.DriveState
import com.example.composepractice.screen.QuotesDetail
import com.example.composepractice.screen.QuotesList
import com.example.composepractice.screen.TestUI
import com.example.composepractice.ui.theme.ComposePracticeTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val jsonArrayData = loadJSONFromAsset(this)



                   if (DataManager.isDataLoaded.value) {
                        if (DataManager.currentPage.value == DataManager.Page.LISTING)
                            QuotesList(data = quotesList(jsonArrayData).toTypedArray()){
                                DataManager.switchPages(it)
                            }
                        else {
                           // DataManager.currentQuotes?.let { QuotesDetail(quotes = it) }

                            DataManager.currentQuotes?.let { QuotesDetail(quotes = it) }
                        }
                    }

                   // TestUI()
                   // DriveState()
                }

            }
        }
    }


}

