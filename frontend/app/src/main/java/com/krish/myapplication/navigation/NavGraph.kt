package com.krish.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.krish.myapplication.presentation.screens.home.HomeScreen

@Composable
fun SetupNavGraph(
    navController : NavHostController
) {

    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(route = Screen.Home.route){
            HomeScreen(navController)
        }
    }
    
}