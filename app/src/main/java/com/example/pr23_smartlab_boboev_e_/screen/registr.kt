package com.example.pr23_smartlab_boboev_e_.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr23_smartlab_boboev_e_.R
import com.example.pr23_smartlab_boboev_e_.Screen
import kotlinx.coroutines.delay

@Composable
fun Registration(navController: NavController) {
    var code by remember { mutableStateOf("") }
    var timeRemainig by remember { mutableStateOf(60) }

    LaunchedEffect(Unit) {
        while (timeRemainig>0){
            delay(1000)
            timeRemainig--
        }
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        IconButton(
            modifier = Modifier.padding(start = 24.dp, top = 24.dp),
            onClick = {
                navController.navigate(Screen.MainScreen.route)
            }
        ) {
            Image(
                painter = painterResource(R.drawable.baseline_arrow_back_ios_24),
                modifier = Modifier.size(32.dp, 32.dp),
                contentDescription = "Cd"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 130.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Введите код из email",
                modifier = Modifier.padding(start = 16.dp)
            )


            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = code,
                onValueChange = { newCode ->
                    code = newCode
                    if (code.length == 4) {
                        navController.navigate(Screen.password.route)
                    }

                },
                label = {
                    Text("Код")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
            )
            Text(
                text = "Отправить код повторно можно будет через ${timeRemainig} секунд",
                modifier = Modifier.padding(top = 5.dp),
                color = colorResource(R.color.button),
                fontSize = 15.sp,
                textAlign = TextAlign.Center

            )

        }
    }
}