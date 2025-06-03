package org.example.project.data.ApiService

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.cio.ChannelIOException
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.example.project.Constants.Constants
import org.example.project.data.WeatherResponse

class ApiService {

    private val httpclient= HttpClient(CIO){
        install(HttpTimeout) {
            requestTimeoutMillis = 300_000 // 120 seconds (2 minutes)
            connectTimeoutMillis = 300_000  // 60 seconds (1 minute)
            socketTimeoutMillis = 300_000  // 120 seconds (2 minutes)
        }
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

