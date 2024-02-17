package com.example.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.presentation.ui.components.rickandmorty.RickAndMortyScreen
import com.example.presentation.ui.ui.components.excel.ExcelLikeGridScreen
import com.example.presentation.ui.ui.components.nested.NestedListsScreen
import com.example.presentation.ui.ui.screens.Screens

@Composable
fun BottomNavBar(navController: NavHostController) {
    BottomNavigation {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        Screens.entries.forEach { screen ->
            BottomNavigationItem(
                icon = { androidx.compose.material.Icon(screen.icon, contentDescription = null) },
                label = { Text(screen.label) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.ScreenOne.route) {
        composable(Screens.ScreenOne.route) { ExcelLikeGridScreen() }
        composable(Screens.ScreenTwo.route) { NestedListsScreen() }
        composable(Screens.ScreenThree.route) { RickAndMortyScreen() }
    }
}
