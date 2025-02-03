package org.example.project.data.ApiService

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.example.project.Constants.Constants
import org.example.project.data.WeatherResponse

class ApiService {

    private val httpclient= HttpClient {
      install(ContentNegotiation){
          json(
              Json {
                  ignoreUnknownKeys = true
                  isLenient = true
                  coerceInputValues = true
                  ignoreUnknownKeys = true

              }
          )
      }
    }

    suspend fun getWeatherByCity(city:String):WeatherResponse{
        
        return httpclient.get(Constants.BASE_URL){
            parameter("q",city)
            parameter("appid",Constants.API_KEY)
        }.body()
    }
}

