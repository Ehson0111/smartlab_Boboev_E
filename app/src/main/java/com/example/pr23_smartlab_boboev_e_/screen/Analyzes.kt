package com.example.pr23_smartlab_boboev_e_.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.example.pr23_smartlab_boboev_e_.R
import com.example.pr23_smartlab_boboev_e_.Screen

@Composable
fun Analyzes(navController: NavController) {
    var search by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("Популярные") }

    val cardDataMap = mapOf(
        "Популярные" to listOf(
            CardData("ПЦР-тест на определение РНК коронавируса стандартный", "1 день", "1800р", {}),
            CardData("Клинический анализ крови с лейкоцитарной формулировкой", "2 день", "690", {}),
            CardData("Биохимический анализ крови, базовый", "1 день", "372р", {}),
            CardData("СОЭ (венозная кровь)", "2 день", "372р", {})
        ),
        "Covid" to listOf(
            CardData("Тут текст", "текст", "текст", {}),
            CardData("Тут текст", "текст", "текст", {}),
            CardData("Тут текст", "текст", "текст", {}),
            CardData("Тут текст", "текст", "текст", {})
        ),
        "Комплексные" to listOf(
            CardData("Тут Комплексные", "текст", "текст", {}),
            CardData("Тут Комплексные", "текст", "текст", {}),
            CardData("Тут Комплексные", "текст", "текст", {}),
            CardData("Тут Комплексные", "текст", "текст", {})
        )
    )

    // Фильтрация карточек на основе поискового запроса
    val filteredCards = cardDataMap[selectedCategory]?.filter { cardData ->
        search.isEmpty() || cardData.title.contains(search, ignoreCase = true)
    } ?: emptyList()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 60.dp)
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .padding(bottom = 5.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = search,
                onValueChange = { search = it },
                label = { Text("Искать анализы") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Показать список",
                        modifier = Modifier.clickable {

                        },
                    )
                }
            )

            // Отображение "Акция и новости" и горизонтального скроллинга категорий только если поиск пустой
            if (search.isEmpty()) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 16.dp),
                    text = "Акция и новости",
                    fontSize = 17.sp,
                    color = colorResource(R.color.button)
                )

                Box(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            contentDescription = "d",
                            painter = painterResource(R.drawable.banner),
                            modifier = Modifier.size(width = 270.dp, height = 152.dp),
                            contentScale = ContentScale.FillBounds
                        )
                        Image(
                            contentDescription = "d",
                            painter = painterResource(R.drawable.banner2),
                            modifier = Modifier
                                .size(270.dp, 152.dp)
                                .padding(start = 17.dp)
                                .clip(RoundedCornerShape(13.dp)),
                            contentScale = ContentScale.FillBounds,

                            )
                    }
                }

                Text(
                    "Каталог анализов",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 1.dp, bottom = 10.dp),
                    fontSize = 17.sp,
                    color = colorResource(R.color.button)
                )

                // Horizontal list of buttons
                Box(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .fillMaxWidth()
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        listOf(
                            "Популярные",
                            "Covid",
                            "Комплексные",
                        ).forEach { category ->
                            Button(
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .padding(8.dp)
                                    .height(50.dp),
                                onClick = { selectedCategory = category },
                                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                    containerColor = if (selectedCategory == category) colorResource(
                                        R.color.button1
                                    ) else colorResource(
                                        R.color.button3
                                    ),
                                )
                            ) {
                                Text(
                                    text = category,
                                    color = if (selectedCategory == category) Color.White else Color.Gray
                                )
                            }
                        }
                    }
                }

                // Отображение всех карточек
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    cardDataMap[selectedCategory]?.forEach { cardData ->
                        item {
                            Card(cardData.title, cardData.day, cardData.money, cardData.onButtonClick)
                        }
                    }
                }
            } else {
                // Отображение "Каталог анализов" и горизонтального скроллинга с результатами поиска
                Text(
                    "Каталог анализов",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 16.dp),
                    fontSize = 17.sp,
                    color = colorResource(R.color.button)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ) {
                    filteredCards.forEach { cardData ->
                        item {
                            Card(cardData.title, cardData.day, cardData.money, cardData.onButtonClick)
                        }
                    }
                }
            }
        }

        // BottomAppBar

        BottomAppBar(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(color = Color.White)
                .fillMaxWidth()
                .height(88.dp)
                .border(width = 0.1.dp, color = colorResource(R.color.button)),
            containerColor = Color.White,
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {

                    IconButton(onClick = { /* Handle home click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.analyzes),
                            contentDescription = "Home",
                            tint = Color.Unspecified
                        )
                    }
                    IconButton(onClick = { /* Handle search click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.result),
                            contentDescription = "Search",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable { navController.navigate(Screen.screenw.route) }
                        )
                    }
                    IconButton(onClick = { /* Handle settings click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.poderzca),
                            contentDescription = "Settings",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable { navController.navigate(Screen.screenw.route) }

                        )
                    }
                    IconButton(onClick = { /* Handle settings click */ }) {
                        Icon(
                            painter = painterResource(R.drawable.user),
                            contentDescription = "Settings",
                            tint = Color.Unspecified,
                            modifier = Modifier.clickable { navController.navigate(Screen.screenw.route) }

                        )
                    }
                }
            }
        )
    }
}

@Composable
fun Card(text: String, day: String, money: String, onButtonClick: () -> Unit) {
    androidx.compose.material.Card(
        modifier = Modifier
            .padding(16.dp)
            .size(width = 355.dp, height = 170.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(23.dp))
            .zIndex(1f),
        contentColor = Color.White,
        shape = RoundedCornerShape(23.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text,
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 16.sp,
                color = Color.Black
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        day,
                        fontSize = 14.sp,
                        color = colorResource(R.color.button)
                    )
                    Text(
                        money,
                        fontSize = 17.sp,
                        color = colorResource(R.color.black)
                    )
                }
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier.align(Alignment.CenterVertically),
                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.button1),
                        contentColor = Color.White
                    )
                ) {
                    Text("Добавить")
                }
            }
        }
    }
}

data class CardData(
    val title: String,
    val day: String,
    val money: String,
    val onButtonClick: () -> Unit
)