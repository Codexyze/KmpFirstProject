package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.example.project.di.startKoinApp

fun main() = application {
    startKoinApp()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Kmp FirstProject",
    ) {
        App()
    }
}