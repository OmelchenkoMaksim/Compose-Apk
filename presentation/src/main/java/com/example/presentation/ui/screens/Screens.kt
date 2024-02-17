package com.example.presentation.ui.ui.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screens(val route: String, val label: String, val icon: ImageVector) {
    ScreenOne("screen_one", "Excel", Icons.Filled.Home),
    ScreenTwo("screen_two", "List into List", Icons.Filled.Favorite),
    ScreenThree("screen_three", "R&M", Icons.Filled.Person)
}
