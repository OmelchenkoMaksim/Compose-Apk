package com.example.presentation.ui.components.rickandmorty

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.data.RickAndMortyCharacter
import com.example.presentation.viewmodels.ScreenThreeViewModel

@Composable
fun RickAndMortyScreen() {
    val viewModel: ScreenThreeViewModel = hiltViewModel()
    val characters by viewModel.characters.collectAsState()

    CharacterList(characters)
}

@Composable
fun CharacterList(characters: List<RickAndMortyCharacter>) {
    LazyColumn {
        items(characters) { character ->
            CharacterRow(character)
        }
    }
}

@Composable
fun CharacterRow(character: RickAndMortyCharacter) {
    Card(modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                painter = rememberAsyncImagePainter(character.image),
                contentDescription = character.name,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = character.name, fontWeight = FontWeight.Bold)
                Text(text = "Status: ${character.status}")
                Text(text = "Species: ${character.species}")
            }
        }
    }
}
