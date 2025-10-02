# 🌦️ Weather App - Kotlin Multiplatform  

A cross-platform **weather application** built with **Kotlin Multiplatform Compose** that runs on **Android** and **Desktop (JVM)** platforms.  
The app fetches real-time weather data from **OpenWeatherMap API** and displays current weather conditions for any city worldwide.  

<div align="center">
  <img src="https://github.com/user-attachments/assets/57a13ea0-33a4-444c-b249-dabd6d2478a3" />
</div>


---

## 🌟 Features  
- 🌍 **Cross-platform**: Runs seamlessly on Android and Desktop (JVM)  
- 🌤️ **Real-time Weather**: Get current weather data for any city  
- 🏗️ **Modern Architecture**: MVVM pattern with Repository pattern  
- 💉 **Dependency Injection**: Koin for clean DI management  
- 🌐 **Network Requests**: Ktor HTTP client with proper error handling  
- 🎨 **Modern UI**: Jetpack Compose with Material Design  
- ⚡ **Reactive State**: Coroutines-based state management  

---

## 🛠️ Tech Stack  
- **Kotlin Multiplatform** – Share business logic across platforms  
- **Jetpack Compose Multiplatform** – Modern declarative UI  
- **Ktor Client** – HTTP networking with CIO/OkHttp engines  
- **Koin** – Lightweight dependency injection  
- **Kotlinx Serialization** – JSON parsing and serialization  
- **Coroutines** – Asynchronous programming  
- **MVVM Architecture** – Clean separation of concerns  
- **Material Design** – Consistent UI components  

---

## 📂 Project Structure  
```bash
composeApp/
├── src/
│   ├── androidMain/kotlin/
│   │   └── org/example/project/
│   │       └── MainActivity.kt
│   ├── desktopMain/kotlin/
│   │   └── org/example/project/
│   │       └── main.kt
│   └── commonMain/kotlin/
│       └── org/example/project/
│           ├── data/
│           │   └── ApiService/
│           │       └── ApiService.kt
│           ├── Repository/
│           │   └── Repository.kt
│           ├── Presentation/
│           │   ├── WeatherViewModel.kt
│           │   └── Screens/
│           │       └── WeatherScreen.kt
│           ├── Navigation/
│           │   └── MyApp.kt
│           ├── di/
│           │   └── AppModule.kt
│           └── App.kt
```
---

## 📦 Dependencies  

```toml
# Core Framework
compose-multiplatform = "1.7.0"
kotlin = "2.1.0"

# Networking
ktor = "3.0.3"
kotlinx-serialization = "1.8.0"

# Dependency Injection
koin = "3.5.6"
koin-compose = "1.1.5"

# Architecture
androidx-lifecycle = "2.8.4"
kotlinx-coroutines = "1.10.1"

```

## ⚙️ Setup & Installation  

### 🔧 Prerequisites  
- Android Studio **Narwhal** or IntelliJ IDEA  
- JDK **11** or higher  
- Android SDK (for Android builds)  
- OpenWeatherMap API key (free tier available)  

### 📥 Installation  
```bash
# Clone the repository
git clone https://github.com/Codexyze/KmpFirstProject
cd weather-app-kmp
```
```
object Constants {
    const val API_KEY = "your_api_key_here"
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/weather"
}
```


