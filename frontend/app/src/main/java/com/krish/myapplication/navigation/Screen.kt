package com.krish.myapplication.navigation

sealed class Screen(val route : String){
    object Home : Screen("home_screen")
    object Add : Screen("add_screen")
}
