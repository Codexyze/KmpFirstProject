package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmpfirstproject.composeapp.generated.resources.Res
import kmpfirstproject.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.example.project.Navigation.MyApp
import org.example.project.Presentation.Screens.WeatherScreen
import org.example.project.Presentation.WeatherViewModel
import org.example.project.Repository.Repository
import org.example.project.data.ApiService.ApiService
import org.example.project.di.startKoinApp
import org.koin.compose.KoinContext
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI

@OptIn(KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
    MaterialTheme {
      // MyApp()


            val viewmodel: WeatherViewModel = koinViewModel<WeatherViewModel>()
            WeatherScreen(viewModel =viewmodel )





    }
}