package com.example.parcial1_rehecho

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial1_rehecho.ui.theme.Parcial1rehechoTheme

@Composable

fun WelcomePage(modifier: Modifier = Modifier, credentials: Credentials){
    Column(modifier = modifier.fillMaxSize()) {
        Text(text = "Bienvenido!", modifier = modifier
            .align(Alignment.CenterHorizontally)
            .padding(10.dp), style = MaterialTheme.typography.displayLarge)
        Text(text = "Usuario: " + credentials.name + " " + credentials.lastName, modifier = modifier.align(Alignment.CenterHorizontally), style = MaterialTheme.typography.displaySmall)
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomePagePreview() {
    val credentials = Credentials("","", "", "")
    Parcial1rehechoTheme {
        WelcomePage(credentials = credentials)
    }
}