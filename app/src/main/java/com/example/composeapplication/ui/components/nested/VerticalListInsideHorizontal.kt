package com.example.composeapplication.ui.components.nested

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun VerticalListInsideHorizontal(horizontalListIndex: Int, horizontalItem: Int) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(3) { verticalItemInsideHorizontal ->
            Text(
                text = "Верт. элемент $verticalItemInsideHorizontal " +
                        "в Гориз. элементе $horizontalItem из Верт. списка $horizontalListIndex",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}