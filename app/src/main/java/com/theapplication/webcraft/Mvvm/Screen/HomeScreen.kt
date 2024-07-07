package com.theapplication.webcraft.Mvvm.Screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.NotificationAdd
import androidx.compose.material.icons.filled.NotificationImportant
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.theapplication.webcraft.Mvvm.Model.Content
import com.theapplication.webcraft.Mvvm.Model.DataModel
import com.theapplication.webcraft.Mvvm.Retrofit.ProductResponse
import com.theapplication.webcraft.Mvvm.Screen.HomeComponent.AutoSlidingCarousel
import com.theapplication.webcraft.Mvvm.Screen.HomeComponent.ProductBox
import com.theapplication.webcraft.Mvvm.Screen.HomeComponent.RowText
import com.theapplication.webcraft.Mvvm.Screen.HomeComponent.SmallBox
import com.theapplication.webcraft.Mvvm.ViewModel.ProductViewModel
import com.theapplication.webcraft.ui.theme.BotttomItemColour

@Composable
fun HomeScreen(productViewModel: ProductViewModel, modifier: Modifier = Modifier) {
    // Column(
    //  ) {
    productViewModel.getdata()
    ResultData(productViewModel = productViewModel)
    // }
}

@Composable
fun ResultData(productViewModel: ProductViewModel, modifier: Modifier = Modifier) {

    val productresult = productViewModel.productResult.observeAsState()

    when (val result = productresult.value) {
        is ProductResponse.Errors -> {
            Column(
                modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = result.message,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )

            }
        }

        is ProductResponse.Sucess -> {
            Column(
//                modifier.verticalScroll(rememberScrollState())
            ) {
                MainHomePage(dataModel = result.data)
            }

        }

        ProductResponse.loading -> {
            Column(
                modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(color = Color.Black, modifier = modifier.size(36.dp))
            }

        }

        null -> {}
    }

}

@Composable
fun MainHomePage(dataModel: DataModel, modifier: Modifier = Modifier) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(BotttomItemColour)

    val imagelist = listOf(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_upF9cgyXK9fYh85mVV-ZEYKw04JcTzUjLw&s",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSukja-McjhByVryhhvbWKyFZiwm-1UhE_TZA&s",
        "https://img.freepik.com/free-photo/portrait-beautiful-stylish-young-woman_158538-4022.jpg",
        "https://i.pinimg.com/564x/9e/6c/a2/9e6ca2ad1dec47b06965cafa1e0c7052.jpg",
    )

    val titles = listOf(
        "Grocery & Foods", "Mobile", "Women", "Men"
    )

    LazyColumn(
        modifier
            .fillMaxSize()
    ) {
        item {
            TopAppbar()
            Imageslide()
            RowText(title = "Most Popular", secondtitle = "View All")

            LazyRow {
                items(dataModel.count()) { item ->
                    ProductBox(dataModel = dataModel)
                }
            }

            SingleBanner()
            RowText(title = "Category", secondtitle = "View All")

            SmallBox(img = imagelist, titles = titles)

            RowText(title = "Featured Product", secondtitle = "View All")

            LazyRow {
                items(dataModel.count()) { item ->
                    ProductBox(dataModel = dataModel)
                }
            }

            Spacer(modifier = modifier.height(90.dp))



        }
    }


}


@Preview(showSystemUi = true)
@Composable
private fun homepreview() {
    //  MainHomePage()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppbar(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .background(BotttomItemColour)
    ) {

        Row(
            modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {


            Icon(
                imageVector = Icons.Filled.AddShoppingCart,
                contentDescription = null,
                modifier.size(30.dp),
                tint = Color.DarkGray
            )
            Spacer(modifier = modifier.width(5.dp))
            TextField(value = "", onValueChange = {},
                modifier
                    .align(Alignment.CenterVertically)
                    .clip(shape = RoundedCornerShape(14.dp))
                    .height(38.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    errorContainerColor = Color.White,
                    errorIndicatorColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    disabledIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White
                ),

                placeholder = {
                    Text(text = "Search your product", fontSize = 12.sp)
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = null,
                        modifier.size(25.dp),
                        tint = Color.Gray
                    )
                })
            Spacer(modifier = modifier.width(5.dp))

            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                modifier.size(30.dp),
                tint = Color.White
            )
        }

    }
}


// ImageSliding

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Imageslide(modifier: Modifier = Modifier) {

    val images = listOf(
        "https://as1.ftcdn.net/v2/jpg/01/75/58/18/1000_F_175581898_6WfYi57vfW0Cfz2MGGeG6I5Qj7rr6ro3.jpg",
        "https://cdn.prod.website-files.com/617bf866dd7a76530b06c57f/65d79c5d538d743a23d656eb_Blog%20Thumbnails.jpg",
        "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg",
        "https://www.shutterstock.com/shutterstock/photos/1841495716/display_1500/stock-vector-great-discount-sale-banner-design-in-d-illustration-on-blue-background-sale-word-balloon-on-1841495716.jpg"

    )

    Card(
        modifier = Modifier.padding(),
        //   shape = RoundedCornerShape(),
    ) {
        AutoSlidingCarousel(
            itemsCount = images.size,
            itemContent = { index ->
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[index])
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.height(150.dp)
                )
            }
        )
    }


}

@Composable
fun SingleBanner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(12.dp))
            .padding(10.dp)
            .height(150.dp)
    ) {
        val imgaddress = "https://vikkys.in/wp-content/uploads/2017/10/All-Products-Banner-3.jpg"

        AsyncImage(model = imgaddress, contentDescription = null, contentScale = ContentScale.Crop, modifier = modifier.clip(shape = RoundedCornerShape(12.dp)))
    }
}