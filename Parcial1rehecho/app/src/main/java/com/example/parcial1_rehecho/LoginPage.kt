package com.example.parcial1_rehecho

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.parcial1_rehecho.ui.theme.Parcial1rehechoTheme

@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onSuccessAttempt : ()->Unit,
    credentials: Credentials
) {
    val credentials = credentials
   var user  by remember {
       mutableStateOf("")
   }
    var password by remember {
       mutableStateOf("")
   }
    var wrongAttempt = remember {
        mutableStateOf(true)
    }
    var firstClick = remember {
        mutableStateOf(true)
    }
//    var user:String = ""
//    var password : String = ""
    Column(modifier= modifier
        .fillMaxSize()
        .padding(10.dp)
    ) {
        if(wrongAttempt.value && !firstClick.value)
        {
            Text(text = "Usuario o contraseña incorrecto",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(10.dp))
        }
        TextField(value = user, onValueChange = {user = it}, label = { Text(text = "Usuario")})
        TextField(value = password, onValueChange = {password = it}, label = { Text(text = "Contraseña")})
        Button(
            onClick = {
                if(credentials.user == user && credentials.password == password)
                {
                    onSuccessAttempt()
                }
                else{
                    wrongAttempt.value = true
                    firstClick.value = false
                }
            } )
        {
            Text(text = "Ingresar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val credentials = Credentials("","", "", "")
    val user :String
    val pass: String
    Parcial1rehechoTheme {
        LoginPage(onSuccessAttempt = {}, credentials = credentials)
    }
}