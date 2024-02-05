package com.example.composeapplication.ui.components.excel

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ExcelLikeGrid(modifier: Modifier = Modifier, rows: Int = 20, columns: Int = 20) {
    val inputs = remember {
        List(rows) { rowIndex ->
            mutableStateListOf<String>().apply {
                repeat(columns) { columnIndex ->
                    add("R${rowIndex + 1} C${columnIndex + 1}")
                }
            }
        }
    }

    LazyColumn(modifier = modifier) {
        itemsIndexed(inputs) { rowIndex, rowInputs ->
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                rowInputs.forEachIndexed { columnIndex, cellValue ->
                    TextField(
                        value = cellValue,
                        onValueChange = { newValue ->
                            inputs[rowIndex][columnIndex] = newValue
                        },
                        modifier = Modifier
                            .width(100.dp)
                            .padding(4.dp),
                        singleLine = true
                    )
                }
            }
        }
    }
}
