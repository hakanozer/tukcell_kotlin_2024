package com.works.days_17

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun Register() {

    var name by remember {  mutableStateOf("")  }
    var email by remember {  mutableStateOf("")  }
    var password by remember {  mutableStateOf("")  }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 45.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "User Register",
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(10.dp))

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = null,
            Modifier.size(50.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = name ,
                onValueChange = {name = it},
                label = { Text(text = "Name") }
            )

            OutlinedTextField(
                value = email ,
                onValueChange = {email = it},
                label = { Text(text = "E-Mail") }
            )

            OutlinedTextField(
                value = password ,
                onValueChange = {password = it},
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation()
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            Log.d("Name", name)
            Log.d("Email", email)
            Log.d("Password", password)

        }) {
            Text(text = "Register", fontSize = 18.sp)
        }
    }

}



