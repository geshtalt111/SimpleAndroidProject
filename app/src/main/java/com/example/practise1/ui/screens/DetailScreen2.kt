package com.example.practise1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

// Дата класс для одной видеокарты
data class GraphicsCard(
    val name: String,
    val description: String,
    val imageURL: String
)

// Дата класс для раздела, который содержит список видеокарт
data class ItemDetail(
    val title: String,
    val graphicsCards: List<GraphicsCard>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen2(navController: NavController, itemId: Int) {

    val itemDescriptions = mapOf(
        1 to ItemDetail(
            title = "RTX 50-SERIES",
            graphicsCards = listOf(
                GraphicsCard(
                    name = "RTX 5060",
                    description = "Самая лучшая (среди бюджетных) видеокарт в 2026 году. Она показывает невероятную производительность за счет новых технологий Nvidia Frame Generator",
                    imageURL = "rtx5060"
                ),
                GraphicsCard(
                    name = "RTX 5070",
                    description = "Отличный выбор для 1440p гейминга. 12GB памяти и отличная производительность в современных играх.",
                    imageURL = "rtx5070"
                ),
                GraphicsCard(
                    name = "RTX 5080",
                    description = "Флагманская карта для 4K гейминга. Поддержка всех современных технологий трассировки лучей.",
                    imageURL = "rtx5080"
                ),
                GraphicsCard(
                    name = "RTX 5090",
                    description = "Абсолютный топ. Для тех, кому нужно всё и сразу. 24GB памяти и максимальная производительность.",
                    imageURL = "rtx5090"
                )
            )
        ),
        2 to ItemDetail(
            title = "RTX 40-SERIES",
            graphicsCards = listOf(
                GraphicsCard(
                    name = "RTX 4060",
                    description = "Бюджетный вариант для 1080p гейминга. Отличное соотношение цена/качество.",
                    imageURL = "rtx4060"
                ),
                GraphicsCard(
                    name = "RTX 4070",
                    description = "Золотая середина. Отлично для 1440p гейминга.",
                    imageURL = "rtx4070"
                ),
                GraphicsCard(
                    name = "RTX 4080",
                    description = "Для требовательных игр в 4K. Высокая производительность.",
                    imageURL = "rtx4080"
                ),
                GraphicsCard(
                    name = "RTX 4090",
                    description = "Прошлый флагман. Всё еще очень мощный для любых задач.",
                    imageURL = "rtx4090"
                )
            )
        ),
        3 to ItemDetail(
            title = "AMD RADEON",
            graphicsCards = listOf(
                GraphicsCard(
                    name = "RX 7600",
                    description = "Бюджетная карта от AMD для 1080p гейминга.",
                    imageURL = "rx7600"
                ),
                GraphicsCard(
                    name = "RX 7700",
                    description = "Хороший вариант для 1440p гейминга.",
                    imageURL = "rx7700"
                ),
                GraphicsCard(
                    name = "RX 7900",
                    description = "Флагман AMD. Отличная производительность за свою цену.",
                    imageURL = "rx7900"
                )
            )
        )
        // Для остальных разделов можно добавить позже
    )

    val item = itemDescriptions[itemId]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(item?.title ?: "В разработке") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(item?.graphicsCards ?: emptyList()) { card ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        // Отображение изображения
                        val imageResId = when (card.imageURL) {
                            "rtx5060" -> R.drawable.rtx5060
                            "rtx5070" -> R.drawable.rtx5070
                            "rtx5080" -> R.drawable.rtx5080
                            "rtx5090" -> R.drawable.rtx5090
                            "rtx4060" -> R.drawable.rtx4060
                            "rtx4070" -> R.drawable.rtx4070
                            "rtx4080" -> R.drawable.rtx4080
                            "rtx4090" -> R.drawable.rtx4090
                            "rx7600" -> R.drawable.rx7600
                            "rx7700" -> R.drawable.rx7700
                            "rx7900" -> R.drawable.rx7900
                            else -> null
                        }

                        imageResId?.let {
                            Image(
                                painter = painterResource(id = it),
                                contentDescription = card.name,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp)
                                    .padding(bottom = 12.dp),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Text(
                            text = card.name,
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        Text(
                            text = card.description,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}