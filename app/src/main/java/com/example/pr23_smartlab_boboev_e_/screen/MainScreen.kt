package com.example.pr23_smartlab_boboev_e_.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pr23_smartlab_boboev_e_.R
import com.example.pr23_smartlab_boboev_e_.Screen

@Composable
fun MainScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    val isEmailEmpty = email.isBlank()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .padding(top = 105.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painterResource(R.drawable.hi_cq933d0bwsx6),
                modifier = Modifier.size(32.dp, 32.dp),
                contentDescription = "+S"
            )
            Text(
                "Добро пожаловать! ",
                fontSize = 24.sp
            )
        }
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Войдите, чтобы пользоваться функциями приложения",
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(67.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Вход по E-mail ") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp)
                .height(60.dp),
            onClick = {
                if (!isEmailEmpty) {
                    navController.navigate(Screen.Registration.route)
                }
            },
            enabled = !isEmailEmpty,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isEmailEmpty) colorResource(R.color.gray1) else colorResource(R.color.blu1)
            ), shape = RoundedCornerShape(8.dp)
        ) {
            Text("Далее")
        }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = {},
                modifier = Modifier.padding(bottom = 30.dp)
            ) {
                Text(
                    "Войти с Яндекс",
                    fontSize = 17.sp,
                    color = Color.Black
                )
            }

        }
    }
}