package com.example.composeapplication.ui

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
import com.example.composeapplication.navigation.AppBottomNavigation
import com.example.composeapplication.ui.screens.ScreenOne
import com.example.composeapplication.ui.screens.ScreenThree
import com.example.composeapplication.ui.screens.ScreenTwo
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

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
