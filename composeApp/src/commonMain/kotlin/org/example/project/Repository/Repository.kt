package org.example.project.Repository

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.serialization.Serializable
import org.example.project.data.ApiService.ApiService
import org.example.project.data.Weather
import org.example.project.data.WeatherResponse

class Repository {
    private val apiService=ApiService()
   suspend fun getWeatherByCity(city: String): WeatherResponse{
      return apiService.getWeatherByCity(city)
   }

}
