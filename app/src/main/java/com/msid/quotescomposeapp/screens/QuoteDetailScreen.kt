package com.msid.quotescomposeapp.screens

import android.telecom.Call.Details
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.msid.quotescomposeapp.DataManager
import com.msid.quotescomposeapp.R
import com.msid.quotescomposeapp.models.Quote


@Composable
fun QuoteDetail(quote: Quote) {

    BackHandler {
        DataManager.switchPages(quote)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                colors = listOf(
                    Color(0xFFffffff),
                    Color(0xFFE3E3E3)
                )
            ))
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            modifier = Modifier.padding(32.dp)
                .width(300.dp)         // fixed width
                .height(250.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F),
                    contentDescription = "Quote"
                )

                Text(
                    text = quote.text,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_regular)
                    ),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 4.dp)

                )
            }

        }
    }
}