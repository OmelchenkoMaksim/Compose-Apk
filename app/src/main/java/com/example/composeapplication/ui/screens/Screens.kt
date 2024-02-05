package com.example.composeapplication.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composeapplication.ui.components.excel.ExcelLikeGridScreen
import com.example.composeapplication.ui.components.nested.NestedListsScreen

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