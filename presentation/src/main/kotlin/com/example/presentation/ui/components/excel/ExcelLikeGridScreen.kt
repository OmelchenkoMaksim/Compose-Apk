package com.example.presentation.ui.ui.components.excel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ExcelLikeGridScreen() {
    ExcelLikeGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}