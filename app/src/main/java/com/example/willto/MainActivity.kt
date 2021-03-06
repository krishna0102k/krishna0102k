package com.example.willto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Grabs our reference to the ComposeView from our layout.
        val composeView = findViewById<ComposeView>(R.id.compose_view)
        // Just like before, use the setContent to display Composable UI.
        composeView.setContent {
            setRecyclerView()
        }
    }

    @Composable
    fun setRecyclerView() {
        val puppies = remember { DataProvider.mainList }
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = puppies,
                itemContent = {
                    PlaceListItem(listings = it)
                })
        }
    }

    @Composable
    fun PlaceListItem(listings: Listings) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            elevation = 2.dp,
            backgroundColor = androidx.compose.ui.graphics.Color.White,
            shape = RoundedCornerShape(corner = CornerSize(16.dp))

        ) {
            Row {
                ListingImage(listings)
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                ) {
                    Text(text = listings.title, style = typography.h6)
                    Text(text = "Entire Place", style = typography.caption)
                }
            }
        }
    }

    @Composable
    private fun ListingImage(listings: Listings) {
        Image(
            painter = painterResource(id = listings.ListingImageId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(84.dp)
                .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
        )
    }

}