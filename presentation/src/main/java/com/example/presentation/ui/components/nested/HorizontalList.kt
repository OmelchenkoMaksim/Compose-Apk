package com.example.presentation.ui.ui.components.nested

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun HorizontalList(horizontalListIndex: Int) {
    LazyRow(modifier = Modifier.height(200.dp)) {
        items(10) { horizontalItem ->
            Card(
                modifier = Modifier
                    .width(150.dp)
                    .padding(8.dp),
                elevation = 2.dp
            ) {
                VerticalListInsideHorizontal(horizontalListIndex, horizontalItem)
            }
        }
    }
}