package com.sonya.pr42

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UserScreen() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var userList by remember { mutableStateOf(UserRepository.getAllUsers()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text("First Name") }
        )
        TextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text("Last Name") }
        )

        Button(onClick = {
            UserRepository.addUser(firstName, lastName)
            userList = UserRepository.getAllUsers() // Обновляем список пользователей
            firstName = "" // Очищаем поле ввода
            lastName = "" // Очищаем поле ввода
        }) {
            Text("Add User")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Users List:")
        userList.forEach { user ->
            Text("${user.firstName} ${user.lastName}")
        }
    }
}
