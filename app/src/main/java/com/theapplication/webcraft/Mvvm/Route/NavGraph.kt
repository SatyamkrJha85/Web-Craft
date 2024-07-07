package com.theapplication.webcraft.Mvvm.Route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapplication.webcraft.Mvvm.Screen.BottomScreen
import com.theapplication.webcraft.Mvvm.ViewModel.ProductViewModel

@Composable
fun NavGraph(productViewModel: ProductViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Route.BottomBar.route) {

        composable(Route.BottomBar.route){
            BottomScreen(productViewModel)
        }


    }
}