package com.example.practise1.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicScreen(navController: NavController) {
    var counter by remember { mutableStateOf(0) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Динамический экран") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text("Нажали кнопку $counter раз")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { counter++ }) {
                Text("Прибавить +1")
            }
        }
    }
}