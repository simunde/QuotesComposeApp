package com.msid.quotescomposeapp.screens

import android.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msid.quotescomposeapp.R
import com.msid.quotescomposeapp.models.Quote


@Composable
fun QuoteListItem(quote: Quote, onClick:(quote:Quote)->Unit){


    // Define custom elevations
    val customElevation = CardDefaults.cardElevation(
        defaultElevation = 8.dp,  // Elevation when the card is at rest
        pressedElevation = 12.dp, // Elevation when the card is pressed
        focusedElevation = 10.dp, // Elevation when the card is focused
        hoveredElevation = 9.dp   // Elevation when the card is hovered over
    )
    Card(
        elevation = customElevation,
        modifier = Modifier
            .clickable { onClick(quote) }
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                contentDescription = "Quote",
                alignment = Alignment.TopStart,
                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
                    .background(Color.Black))


        
        Spacer(modifier = Modifier.padding(4.dp))
        Column(modifier = Modifier.weight(1f)) {
            
            Text(text = quote.text,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(   0.dp,0.dp,0.dp,8.dp)
            )
            Box(modifier = Modifier
                .background(Color(0xFFEEEEEE))
                .fillMaxWidth(.4f)
                .height(1.dp)
            )

            Text(text = quote.author,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(   4.dp)
            )


        }
        }

    }
}


