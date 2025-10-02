package org.example.project.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.example.project.Presentation.WeatherViewModel
import org.example.project.Repository.Repository
import org.example.project.data.ApiService.ApiService
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module{
   factory<ApiService> {
       ApiService()

   }
    single<Repository> {
        Repository(get())

    }
    viewModel<WeatherViewModel> {
        WeatherViewModel(get())

    }


}

fun startKoinApp(){
    startKoin {
        modules(appModule)
    }
}