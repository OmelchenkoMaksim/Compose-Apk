package com.example.presentation.ui.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screens(val route: String, val label: String, val icon: ImageVector) {
    ScreenOne("screen_one", "Screen 1", Icons.Filled.Home),
    ScreenTwo("screen_two", "Screen 2", Icons.Filled.Favorite),
    ScreenThree("screen_three", "Screen 3", Icons.Filled.Person)
}
