package com.example.practise1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.practise1.ui.bottomnav.BottomNavBar
import com.example.practise1.ui.screens.AppNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = { BottomNavBar(navController) }
                ) { innerPadding ->
                    AppNavHost(navController = navController, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}