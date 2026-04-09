package com.example.practise1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.practise1.R

data class ItemDetail(
    val description: String,
    val imageURL: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen2(navController: NavController, itemId: Int) {

    val itemDescriptions = mapOf(
        1 to ItemDetail(
            description = "Rtx 5060 - Самая лучшая (среди бюджетных) видеокарт в 2026 году. Она показывает невероятную производительность за счет новых технологий Nvidia Frame Generator",
            imageURL = "rtx5060"
        ),
        2 to ItemDetail(
            description = "Элемент 2 — пара и баланс. Два конца одной прямой, два берега одной реки.",
            imageURL = ""
        ),
        3 to ItemDetail(
            description = "Элемент 3 — троица и устойчивость. Три точки задают плоскость, три ноги держат стол.",
            imageURL = ""
        ),
        4 to ItemDetail(
            description = "Элемент 4 — четыре стороны света. Квадрат — символ порядка и стабильности.",
            imageURL = ""
        ),
        5 to ItemDetail(
            description = "Элемент 5 — пятёрка, золотая середина. Пять пальцев, пять чувств, пять элементов.",
            imageURL = ""
        ),
        6 to ItemDetail(
            description = "Элемент 6 — шесть граней куба. Совершенное число, равное сумме своих делителей.",
            imageURL = ""
        ),
        7 to ItemDetail(
            description = "Элемент 7 — магическое число. Семь нот, семь дней недели, семь чудес света.",
            imageURL = ""
        ),
        8 to ItemDetail(
            description = "Элемент 8 — восьмёрка, знак бесконечности. Октава замыкает музыкальный круг.",
            imageURL = ""
        )
    )

    val item = itemDescriptions[itemId]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    when (itemId){
                        1 -> "RTX-SERIES"
                        else -> "В разработке"
                    }
                ) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Гибкое отображение изображения
            val imageResId = when (item?.imageURL) {
                "rtx5060" -> R.drawable.rtx5060

                else -> null
            }

            // Показываем изображение только если ресурс найден
            imageResId?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = "Изображение для элемента $itemId",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(bottom = 16.dp),
                    contentScale = ContentScale.Crop
                )
            }

            Text(
                when (itemId){
                    1 -> "RTX-SERIES INFORMATION"
                    else -> "???"
                },
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            Text(
                text = item?.description ?: "Информация об элементе $itemId",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}