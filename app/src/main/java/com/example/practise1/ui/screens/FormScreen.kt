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
fun FormScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Форма") }) }
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)) {

            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Введите текст") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.navigate("screen_dynamic") }) {
                Text("Отправить")
            }
        }
    }
}