package com.theapplication.webcraft.Mvvm.Screen.HomeComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowText(title:String,secondtitle:String,modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp, top = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = title, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)
        Text(text = secondtitle, fontSize = 12.sp, color = Color.Black, fontWeight = FontWeight.Normal)
    }
}