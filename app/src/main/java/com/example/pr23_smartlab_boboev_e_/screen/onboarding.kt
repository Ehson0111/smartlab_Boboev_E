package com.example.pr23_smartlab_boboev_e_.screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr23_smartlab_boboev_e_.R
import com.example.pr23_smartlab_boboev_e_.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    var text by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, top = 50.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(
                onClick = {
                    navController.navigate(Screen.MainScreen.route)
                },
            ) {
                text = if (pagerState.currentPage == 2) "Завершить" else "Пропустить"
                Text(text, color = colorResource(R.color.blu1))
            }
            Image(
                painter = painterResource(R.drawable.subtract),
                contentDescription = "+e"
            )
        }

        HorizontalPager(
            count = 3,
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->


            // Content for each page
            when (page) {
                0 ->
                    OnboardingPage(
                        title = "Анализы",

                        description = "Экспресс сбор и получение проб",
                        imageRes = R.drawable.llustration1,
                         pagerState,


                        )

                1 -> OnboardingPage(
                    title = "Уведомление",
                    description = "Вы быстро узнаете о результатах",
                    imageRes = R.drawable.swg2,
                    pagerState,


                    )

                2 -> OnboardingPage(
                    title = "Мониторинг",

                    description = "Наши врачи всегда наблюдают \n" +
                            "за вашими показателями здоровья",
                    imageRes = R.drawable.swg3, pagerState,


                    )
            }
        }

        // Indicators for the pager

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingPage(title: String, description: String, imageRes: Int, pagerState: PagerState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title, modifier = Modifier.padding(bottom = 30.dp),
            color = colorResource(R.color.title),
            fontSize = 32.sp

        )
        Text(
            text = description, modifier = Modifier.padding(bottom = 60.dp),

            )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) {
                val color =
                    if (pagerState.currentPage == it) colorResource(R.color.title1) else colorResource(
                        R.color.white
                    )
                Box(
                    modifier = Modifier
                        .padding(bottom = 105.dp, start = 14.dp)
                        .size(10.dp)
                        .background(color, RoundedCornerShape(18.dp))
                        .border(
                            width = 1.dp,
                            color = colorResource(R.color.title1),
                            shape = RoundedCornerShape(16.dp)
                        ),

                    )
            }
        }
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 316.dp, height = 217.dp)
        )
    }
}