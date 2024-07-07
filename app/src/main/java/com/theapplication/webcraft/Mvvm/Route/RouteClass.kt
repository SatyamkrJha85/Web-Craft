package com.theapplication.webcraft.Mvvm.Route

sealed class Route  (val route:String){

    object Home :Route("home")
    object Category :Route("category")
    object Cart :Route("cart")
    object Offers :Route("offers")
    object Account :Route("account")
    object BottomBar :Route("bottombar")



}