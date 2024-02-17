package com.example.presentation.ui.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.presentation.ui.ui.components.excel.ExcelLikeGridScreen
import com.example.presentation.ui.ui.components.nested.NestedListsScreen

@Composable
fun ScreenOne() {
    ExcelLikeGridScreen()
}

@Composable
fun ScreenTwo() {
    NestedListsScreen()
}

@Composable
fun ScreenThree() {
    Text(
        "Экран 3", modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}