package com.example.willto

data class Listings(
    val id: Int,
    val title: String,
    val sex: String,
    val age: Int,
    val description: String,
    val ListingImageId: Int = 0
)