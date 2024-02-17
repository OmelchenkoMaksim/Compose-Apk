package com.example.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.presentation.ui.ui.components.excel.ExcelLikeGridScreen
import com.example.presentation.ui.ui.components.nested.NestedListsScreen
import com.example.presentation.ui.ui.screens.Screens
import com.example.presentation.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    val viewModel: MainViewModel = viewModel()
    val showSnackbar by viewModel.showSnackbar.collectAsState()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            scaffoldState.snackbarHostState.showSnackbar(
                message = "Нет соединения с интернетом"
            )
        }
    }

    MaterialTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { BottomNavBar(navController) }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                NavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    BottomNavigation {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        Screens.entries.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
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
        composable(Screens.ScreenThree.route) {
            Text(
                "Экран 3",
                Modifier
                    .fillMaxSize()
                    .wrapContentSize()
            )
        }
    }
}
