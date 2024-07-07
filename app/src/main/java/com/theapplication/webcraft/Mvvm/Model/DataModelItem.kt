package com.theapplication.webcraft.Mvvm.Model

data class DataModelItem(
    val contents: List<Content>,
    val id: String,
    val image_url: String,
    val title: String,
    val type: String
)