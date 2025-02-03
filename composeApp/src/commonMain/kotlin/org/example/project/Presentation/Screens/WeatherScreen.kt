package org.example.project.Presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import org.example.project.Presentation.WeatherViewModel

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seiko.imageloader.rememberAsyncImagePainter

import org.example.project.Presentation.Result

import org.example.project.data.WeatherResponse
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    var cityName by remember { mutableStateOf("") } // User input for city

    val state by viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text("Enter City") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { viewModel.getWeatherByCity(cityName) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Get Weather")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (state) {
            is Result.Loading -> CircularProgressIndicator()
            is Result.Success -> WeatherDetails((state as Result.Success).data)
            is Result.Error -> Text("Error: ${(state as Result.Error).message}", color = Color.Red)
        }
    }
}
@Composable
fun WeatherDetails(weather: WeatherResponse) {
    val iconUrl = "https://openweathermap.org/img/wn/${weather.weather.firstOrNull()?.icon}@2x.png"

    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(weather.name ?: "Unknown City", fontSize = 28.sp, fontWeight = FontWeight.Bold)

            Image(
                painter = rememberAsyncImagePainter(iconUrl),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Fit
            )

            Text(weather.weather.firstOrNull()?.description?.capitalize() ?: "", fontSize = 20.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(8.dp))

            Text("Temperature: ${weather.main?.temp}°C", fontSize = 20.sp)
            Text("Feels like: ${weather.main?.feels_like}°C", fontSize = 16.sp)
            Text("Humidity: ${weather.main?.humidity}%", fontSize = 16.sp)
            Text("Wind Speed: ${weather.wind?.speed} m/s", fontSize = 16.sp)
        }
    }
}
