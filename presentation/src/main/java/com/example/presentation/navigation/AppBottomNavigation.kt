package com.example.presentation.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun AppBottomNavigation(navController: NavController) {
    BottomNavigation {
        val items = listOf("screen_one", "screen_two", "screen_three")
        items.forEach { screen ->
            BottomNavigationItem(
                label = { Text(screen) },
                icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                selected = false,
                onClick = {
                    navController.navigate(screen) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}