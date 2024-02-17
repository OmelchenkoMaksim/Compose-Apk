package com.example.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.presentation.ui.navigation.BottomNavBar
import com.example.presentation.ui.navigation.NavGraph
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
    val viewModel: MainViewModel = hiltViewModel()
    val showSnackbar by viewModel.showSnackbar.collectAsState()
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(showSnackbar) {
        if (showSnackbar) {
            scaffoldState.snackbarHostState.showSnackbar(
                message = "Lost internet connection"
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
