package com.example.practise1.ui.screens
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen2(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Детали") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)) {
            AsyncImage(
                model = "https://sun9-18.userapi.com/s/v1/ig2/00rmKnE6i8e4NJ-iyLe_fmIP9tP_jjJYoHoW7wm53dbWCrFhFyH7w0OFQjiAz3ccx979q3R9WK8kdjdTChjN11se.jpg?quality=95&as=32x28,48x42,72x63,108x95,160x140,240x210,360x315,480x420,540x473,640x560,720x631,1080x946,1280x1121&from=bu&cs=1280x0",
                contentDescription = "Деталь",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(bottom = 15.dp),
                contentScale = ContentScale.Crop)
            Text("Элемент — это составная часть, компонент сложной системы, структуры или множества")


        }
    }
}