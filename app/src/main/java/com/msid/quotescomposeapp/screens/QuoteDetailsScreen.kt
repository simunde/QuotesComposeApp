package com.msid.quotescomposeapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import com.msid.quotescomposeapp.DataManager
import com.msid.quotescomposeapp.R
import com.msid.quotescomposeapp.models.Quote

@Composable
fun QuoteDetails(quote: Quote){

    BackHandler() {
        DataManager.switchPages(null)
    }

    // Define custom elevations
    val customElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,  // Elevation when the card is at rest
        pressedElevation = 12.dp, // Elevation when the card is pressed
        focusedElevation = 10.dp, // Elevation when the card is focused
        hoveredElevation = 9.dp   // Elevation when the card is hovered over
    )
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
                )
            )
    ){
        Card(
            elevation = customElevation,
            modifier = Modifier.padding(32.dp)
        ) {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally, // Correct alignment setting for Column

                modifier = Modifier
                    .padding(16.dp, 24.dp)
            ) {
                Image(

                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F)
                )
                Text(text = quote.text,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_regular)
                    ),
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(Modifier.height(16.dp))
                Text(text = quote.author,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_regular)
                    ),
                    style = MaterialTheme.typography.headlineSmall
                )

            }

        }
    }
}
