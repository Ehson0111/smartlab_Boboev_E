package com.example.pr23_smartlab_boboev_e_.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.pr23_smartlab_boboev_e_.R
import com.example.pr23_smartlab_boboev_e_.Screen
import androidx.compose.material.icons.filled.ArrowDropDown as ArrowDropDown1

@Composable
fun Patient_Record(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var Otchestvo by remember { mutableStateOf("") }
    var familiya by remember { mutableStateOf("") }
    var dara_rozdenie by remember { mutableStateOf("") }

    val isEmailEmpty = name.isBlank()

    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }


    val isNameEmpty = name.isBlank() //isNameEmpty принимает значение true, если строка selectedText пуста,
    val isOtchestvoEmpty = Otchestvo.isBlank()
    val isFamiliyaEmpty = familiya.isBlank()
    val isDataRozdenieEmpty = dara_rozdenie.isBlank()
    val ispol = selectedText.isBlank()

    val isFormValid =!isNameEmpty && !isOtchestvoEmpty && !isFamiliyaEmpty && !isDataRozdenieEmpty && !ispol  //true если не пустое


    val items = listOf("Мужской", "Женский")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 70.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()

        ) {
            Text(
                modifier = Modifier.width(240.dp),
                text = "Создание карты пациента ",
                color = Color.Black,
                fontSize = 24.sp
            )
            TextButton(onClick = {
                navController.navigate(Screen.Analyzes.route)
            }) {
                Text(
                    modifier = Modifier.padding(start = 15.dp), text = "Пропустить ",
                    color = colorResource(R.color.button1),
                    fontSize = 15.sp
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            fontSize = 12.sp,
            text = "Без карты пациента вы не сможете заказать анализы.",
            color = colorResource(R.color.button)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 32.dp),
            fontSize = 12.sp,

            text = "В картах пациентов будут храниться результаты анализов вас и ваших близких.",
            color = colorResource(R.color.button)
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            value = name,
            onValueChange = { new ->
                name = new
            },
            label = {
                Text("Имя")
            }

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            value = familiya,
            onValueChange = { new ->
                familiya = new
            },
            label = {
                Text("Фамилия")
            }

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            value = Otchestvo,
            onValueChange = { new ->
                Otchestvo = new
            },
            label = {
                Text("Отчество")
            }

        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            value = dara_rozdenie,
            onValueChange = { new ->
                dara_rozdenie = new
            },
            label = {
                Text("Дата рождение")
            }

        )

        OutlinedTextField(
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->

                    textFieldSize = coordinates.size.toSize()
                },
            value = selectedText,
            onValueChange = { selectedText = it },
            label = { Text("Пол") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown1,
                    contentDescription = "Показать список",
                    modifier = Modifier.clickable {
                        expanded = !expanded
                    }
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) {
                    textFieldSize.width.toDp()
                })
        ) {
            items.forEach { label ->
                DropdownMenuItem(
                    onClick = {
                        selectedText = label
                        expanded = false
                    }
                ) {
                    Text(text = label)
                }
            }
        }

        Button(
            onClick = {
                if (isFormValid) {
                navController.navigate(Screen.Analyzes.route)}
            },
            modifier = Modifier
                .fillMaxWidth().width(356.dp)
                .padding(top = 48.dp) ,
            enabled = isFormValid,

            colors = ButtonDefaults.buttonColors(
                backgroundColor = if (isFormValid) colorResource(R.color.blu1) else colorResource(R.color.button2),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Создать")
        }
    }
}