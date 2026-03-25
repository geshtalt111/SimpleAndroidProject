package com.example.practise1.ui.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ViewModule
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem("screen_list", "Список", Icons.Filled.List),
    BottomNavItem("screen_form", "Главная форма", Icons.Filled.Edit),
    BottomNavItem("screen_grid", "Сетка", Icons.Filled.ViewModule)
)