package com.theapplication.webcraft.Mvvm.Screen.HomeComponent

import android.text.Layout
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@Composable
fun SmallBox(img: List<String>, titles: List<String>, modifier: Modifier = Modifier) {
    LazyRow(modifier = modifier) {
        items(titles.size) { index ->
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .width(100.dp)
                    .height(90.dp)
                    .border(border = BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(12.dp))
                   , contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    AsyncImage(
                        model = img[index],
                        contentDescription = titles[index],
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(1.dp))
                    Text(text = titles[index], fontSize = 10.sp, color = Color.Gray)
                }
            }
        }
    }
}
