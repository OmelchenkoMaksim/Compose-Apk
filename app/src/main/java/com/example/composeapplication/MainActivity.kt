package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

@Composable
fun AppBottomNavigation(navController: NavController) {
    BottomNavigation {
        val items = listOf("screen_one", "screen_two", "screen_three")
        items.forEach { screen ->
            BottomNavigationItem(
                label = { Text(screen) },
                icon = { Icon(Icons.Default.Favorite, contentDescription = null) },
                selected = false,
                onClick = {
                    navController.navigate(screen) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) { saveState = true }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Composable
fun ExcelLikeGridScreen() {
    ExcelLikeGrid(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp))
}

@Composable
fun ExcelLikeGrid(modifier: Modifier = Modifier, rows: Int = 20, columns: Int = 20) {
    // Инициализируем значения в ячейках номерами строки и столбца
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

@Composable
fun ScreenOne() {
    ExcelLikeGridScreen()
}

@Composable
fun ScreenTwo() {
    NestedLists()
}

@Composable
fun ScreenThree() {
    Text("Экран 3", modifier = Modifier
        .fillMaxSize()
        .wrapContentSize())
}


@Composable
fun NestedLists() {
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

@Composable
fun VerticalListInsideHorizontal(horizontalListIndex: Int, horizontalItem: Int) {
    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(3) { verticalItemInsideHorizontal ->
            Text(
                text = "Верт. элемент $verticalItemInsideHorizontal в Гориз. элементе $horizontalItem из Верт. списка $horizontalListIndex",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}
