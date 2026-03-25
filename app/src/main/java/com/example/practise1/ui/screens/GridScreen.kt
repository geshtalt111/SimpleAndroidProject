package com.example.practise1.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun GridScreen(navController: NavController) {
    val itemsList = List(6) { "Элемент ${it + 1}" }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Сетка") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF03DAC5),
                    titleContentColor = Color.Black
                )
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(itemsList) { item ->
                    Card(
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable { navController.navigate("screen_detail") }
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            contentAlignment = androidx.compose.ui.Alignment.Center
                        ) {
                            Text(item)
                        }
                    }
                }
            }
        }
    }
}