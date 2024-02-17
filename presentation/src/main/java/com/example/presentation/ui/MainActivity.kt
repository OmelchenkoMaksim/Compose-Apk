package com.example.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.ui.navigation.AppBottomNavigation
import com.example.presentation.ui.ui.screens.ScreenOne
import com.example.presentation.ui.ui.screens.ScreenThree
import com.example.presentation.ui.ui.screens.ScreenTwo
import com.example.presentation.ui.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeApplicationTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { AppBottomNavigation(navController) }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "screen_one") {
                            composable("screen_one") { ScreenOne() }
                            composable("screen_two") { ScreenTwo() }
                            composable("screen_three") { ScreenThree() }
                        }
                    }
                }
            }
        }
    }
}
