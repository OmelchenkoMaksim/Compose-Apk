package com.example.presentation.ui.ui.components.nested

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NestedListsScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(5) { verticalItem ->
            Text(
                text = "Вертикальный элемент $verticalItem",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
            HorizontalList(horizontalListIndex = verticalItem)
        }
    }
}