package org.example.project.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.Screens.HomeScreen
import org.example.project.Screens.LoginScreen

@Composable
fun MyApp() {
    val navHostController = rememberNavController()
 NavHost(navController = navHostController, startDestination = LoginScreen){
     composable<HomeScreen> {
         HomeScreen()
     }
     composable<LoginScreen> {
         LoginScreen(navHostController)
     }

 }


}