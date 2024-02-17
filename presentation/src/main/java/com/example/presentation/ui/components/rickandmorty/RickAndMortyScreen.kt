package com.example.presentation.ui.components.rickandmorty

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.domain.RickAndMortyCharacter
import com.example.presentation.viewmodels.RickAndMortyScreenViewModel

@Composable
fun RickAndMortyScreen(viewModel: RickAndMortyScreenViewModel = hiltViewModel()) {
    val characters by viewModel.characters.collectAsState()
    val listState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(state = listState) {
            items(characters) { character ->
                CharacterRow(character)
            }
        }
    }

    val endReached by remember {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            layoutInfo.visibleItemsInfo.isNotEmpty() &&
                    layoutInfo.visibleItemsInfo.last().index == characters.lastIndex
        }
    }

    LaunchedEffect(endReached) {
        if (endReached) {
            viewModel.loadNextPage()
        }
    }
}


@Composable
fun CharacterRow(character: RickAndMortyCharacter) {
    Row(modifier = Modifier.padding(16.dp)) {
        Image(
            painter = rememberAsyncImagePainter(character.image),
            contentDescription = character.name,
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = character.name,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.White
            )
            Text(
                text = "Status: ${character.status}",
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = "Species: ${character.species}",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }
}
