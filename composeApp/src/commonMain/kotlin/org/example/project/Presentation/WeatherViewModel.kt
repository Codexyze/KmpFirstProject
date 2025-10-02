package org.example.project.Presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.Repository.Repository
import org.example.project.data.WeatherResponse

class WeatherViewModel (private  val repository: Repository) : ViewModel() {

    // Mutable state for UI
    private val _state = mutableStateOf<Result<WeatherResponse>>(Result.Loading)
    val state get() = _state // Expose as read-only

    // Function to fetch weather data
    fun getWeatherByCity(city: String) {
        _state.value = Result.Loading // Show loading state

        viewModelScope.launch {
            try {
                val response = repository.getWeatherByCity(city)
                _state.value = Result.Success(response) // Success state
            } catch (e: Exception) {
                _state.value = Result.Error(e.message ?: "Unknown error") // Handle error
            }
        }
    }
}

// Sealed class for handling different states
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}
