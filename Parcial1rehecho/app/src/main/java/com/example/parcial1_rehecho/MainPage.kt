package com.example.parcial1_rehecho

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial1_rehecho.ui.theme.Parcial1rehechoTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(modifier: Modifier = Modifier) {
//    val credentials = remember {
//        mutableStateOf(Credentials("nahuelc", "1234"))
//    }
    val email:String= "pedro@pe.com.ar"
    val password: String = "abc123"
    val credentials = Credentials(user = email,password = password, name="Pepe", lastName = "Pepito")
    val navHostController = rememberNavController()
    Scaffold(modifier = modifier, topBar = {
        TopAppBar(title = { Text(text = "Parcial 1") }, colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = MaterialTheme.colorScheme.primary,
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ))
    }) {
        MainNavHost(
            navHostController = navHostController,
            modifier = modifier.padding(it),
            credentials = credentials
        )
    }
}

@Composable
fun MainNavHost(modifier: Modifier = Modifier,
                navHostController : NavHostController,
                credentials: Credentials
                )
{
    NavHost(navController = navHostController, modifier = modifier ,startDestination = "login")
    {
        composable("login"){
            LoginPage(credentials = credentials, onSuccessAttempt = {
                navHostController.navigate("successLogin")
            })
        }
        composable("successLogin")
        {
            WelcomePage(credentials = credentials)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    Parcial1rehechoTheme {
        MainPage()
    }
}