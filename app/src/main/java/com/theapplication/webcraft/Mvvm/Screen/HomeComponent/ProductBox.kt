package com.theapplication.webcraft.Mvvm.Screen.HomeComponent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.StarHalf
import androidx.compose.material.icons.outlined.StarOutline

import kotlin.math.ceil
import kotlin.math.floor
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.theapplication.webcraft.Mvvm.Model.DataModel
import com.theapplication.webcraft.R
import com.theapplication.webcraft.ui.theme.OfferbuttonColour

@Composable
fun ProductBox(dataModel: DataModel,modifier: Modifier = Modifier) {


    val imagelist = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRnjTnhdYKf6Kpc-U7Qb_rWn5eeiJ9OMYx6uQ&s",
        "https://static.vecteezy.com/system/resources/thumbnails/024/841/285/small/wireless-headphone-isolated-on-transparent-background-high-quality-bluetooth-headphone-for-advertising-and-product-catalogs-generative-ai-png.png",
        "https://static.vecteezy.com/system/resources/thumbnails/023/638/040/small/spa-cosmetic-with-vintage-bottles-soap-and-brush-for-aromatherapy-hand-drawn-watercolor-illustration-of-bodycare-products-for-massage-on-isolated-transparent-background-drawing-of-care-toiletries-png.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNtY_Hfb4EKnz8KyVTLZo4sbTOkNrhNBt1NQ&s",
        "https://static.vecteezy.com/system/resources/thumbnails/041/642/641/small_2x/ai-generated-cleaning-product-isolated-on-transparent-background-png.png"
    )

    val ratinglist = listOf(
        3.4,3.5,2.5,4.5,5.0
    )

    val therandomlist=ratinglist.random()

    val theimglist = imagelist.random()

    val firstItem = dataModel.firstOrNull()
    val firstContent = firstItem?.contents?.firstOrNull()

    val Seconditem = dataModel.firstOrNull()
    val SecondContent = Seconditem?.title?.firstOrNull()



    Box(
        modifier = modifier
            .width(180.dp)
            .padding(10.dp)
            .height(280.dp)
            .border(border = BorderStroke(1.dp, Color.Gray), shape = RoundedCornerShape(12.dp))
    ) {

        Column {
            Row(
                modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {


                AsyncImage(model = theimglist, contentDescription =null,
                    modifier
                        .padding(top = 10.dp)
                        .size(110.dp)
                    )

            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp)
            ) {
                ElevatedButton(
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(6.dp),
                    modifier = modifier
                        .width(120.dp)
                        .height(35.dp),
                    colors = ButtonDefaults.buttonColors(
                        OfferbuttonColour
                    )
                ) {
                    Text(text = "Sale 60% off", color = Color.Black, fontSize = 10.sp)
                }
            }
            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            ) {
                Seconditem?.title?.let {
                    Text(
                        text = it,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )
                }
            }

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            ) {
                RatingBar(rating = therandomlist)
            }

            Row(
                modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            ) {
                Text(text = "300", color = Color.Gray)
                Spacer(modifier = modifier.width(10.dp))
                Text(text = "500", textDecoration = TextDecoration.LineThrough)

            }
        }
    }
}



@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
) {
    val filledStars = floor(rating).toInt()
    val unfilledStars = (stars - ceil(rating)).toInt()
    val halfStar = !(rating.rem(1).equals(0.0))
    Row(modifier = modifier) {
        repeat(filledStars) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = OfferbuttonColour)
        }
        if (halfStar) {
            Icon(
                imageVector = Icons.Outlined.StarHalf,
                contentDescription = null,
                tint = OfferbuttonColour
            )
        }
        repeat(unfilledStars) {
            Icon(
                imageVector = Icons.Outlined.StarOutline,
                contentDescription = null,
                tint = Color.Gray
            )
        }
    }
}
