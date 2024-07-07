package com.theapplication.webcraft.Mvvm.Screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapplication.webcraft.Mvvm.Route.Route
import com.theapplication.webcraft.Mvvm.Utils.NavigationItemData
import com.theapplication.webcraft.Mvvm.ViewModel.ProductViewModel
import com.theapplication.webcraft.ui.theme.BotttomItemColour
import com.theapplication.webcraft.ui.theme.Botttomwhite

@Composable
fun BottomScreen(productViewModel: ProductViewModel,modifier: Modifier = Modifier) {


val navController = rememberNavController()
    Scaffold(
        containerColor = Color.White,

        bottomBar = {

            BottomNavigationBar(
                modifier = Modifier.fillMaxWidth(),
                navItems = listOf(
                    NavigationItemData(Icons.Filled.Home, "Home"),
                    NavigationItemData(Icons.Filled.Dashboard, "Category"),
                    NavigationItemData(Icons.Filled.ShoppingCart, "Cart"),
                    NavigationItemData(Icons.Filled.LocalOffer, "Offers"),
                    NavigationItemData(Icons.Filled.Person, "Account"),

            ),
                defaultSelectedIndex = 0,
                itemSelected = { index, reselected ->
                    if (!reselected) {


                        when (index) {
                            0 -> navController.navigate(Route.Home.route)
                            1 -> navController.navigate(Route.Category.route)
                            2 -> navController.navigate(Route.Cart.route)
                            3 -> navController.navigate(Route.Offers.route)
                            4 -> navController.navigate(Route.Account.route)
                        }
                    }
                }
            )
        }

    ) {it


        NavHost(
            navController = navController,
            startDestination = Route.Home.route,
            modifier = Modifier.padding()
        ) {
            composable( Route.Home.route) {
                HomeScreen(productViewModel)
            }

            composable( Route.Category.route) {
                CategoryScreen()
            }

            composable( Route.Cart.route) {
                CartScreen()
            }

            composable( Route.Offers.route) {
                OfferScreen()
            }
            composable( Route.Account.route) {
                AccountScreen()
            }

        }
    }
}
@Composable
fun BottomNavigationBar(
    navItems: List<NavigationItemData>,
    modifier: Modifier = Modifier,
    internalPadding: Dp = 8.dp,
    iconSize: Dp = 24.dp,
    fontSize: TextUnit = 12.sp,
    defaultSelectedIndex: Int = 0,
    selectedItemOffset: Dp = 8.dp,
    shape: androidx.compose.ui.graphics.Shape = RoundedCornerShape(8.dp),
    navigationBarColor: Color = Botttomwhite,
    itemTint: Color = Gray,
    selectedItemTint: Color = White,
    backgroundTint: Color = Color.Transparent,
    selectedBackgroundTint: Color =BotttomItemColour,
    itemSelected: (index: Int, reselected: Boolean) -> Unit
) {

    Box(
        modifier = Modifier
            .height(63.dp)
            .background(navigationBarColor, shape)
            .then(modifier),
    ) {

        var selectedItemIndex by remember {
            mutableIntStateOf(defaultSelectedIndex)
        }

        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            navItems.forEachIndexed { index, item ->

                val isSelected = selectedItemIndex == index

                Box(
                    Modifier
                        .fillMaxSize()
                        .weight(1f)
                        .clickable {
                            val reselected = selectedItemIndex == index
                            selectedItemIndex = index
                            itemSelected(selectedItemIndex, reselected)
                        },
                    contentAlignment = Alignment.Center
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .then(
                                if (isSelected) {
                                    Modifier.offset(y = selectedItemOffset * (-1))
                                } else {
                                    Modifier
                                }
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Box(
                            Modifier
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) selectedBackgroundTint else backgroundTint
                                )
                                .padding(internalPadding)
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                modifier = Modifier.size(iconSize),
                                tint = if (isSelected) selectedItemTint else itemTint
                            )
                        }

                        AnimatedVisibility(visible = isSelected) {
                            Text(
                                text = item.title,
                                modifier = Modifier.padding(top = 4.dp),
                                color = Gray,
                                fontSize = fontSize
                            )
                        }

                    }

                }

            }

        }

    }

}