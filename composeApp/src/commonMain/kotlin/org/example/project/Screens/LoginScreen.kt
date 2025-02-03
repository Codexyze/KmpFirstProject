package org.example.project.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.example.project.Navigation.HomeScreen

@Composable
fun LoginScreen(navController: NavController) {
    Column {
        Text("Hello This is my Login screen")
        Button(onClick = {
            navController.navigate(HomeScreen)
        }){
            Text("Login")
        }

    }


}