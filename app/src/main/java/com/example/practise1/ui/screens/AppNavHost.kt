package com.example.practise1.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.practise1.ui.screens.GridScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = "screen_list",
        modifier = modifier
    ) {
        composable("screen_list") { ListScreen(navController) }
        composable("screen_detail2"){ DetailScreen2(navController)}
        composable("screen_form") { FormScreen(navController) }
        composable("screen_grid") { GridScreen(navController) }
        composable("screen_detail") { DetailScreen(navController) }
        composable("screen_dynamic") { DynamicScreen(navController) }
    }
}