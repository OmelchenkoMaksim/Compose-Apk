package com.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.RickAndMortyCharacter
import com.example.data.RickAndMortyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScreenThreeViewModel @Inject constructor(
    private val repository: RickAndMortyRepository
) : ViewModel() {
    private val _characters = MutableStateFlow<List<RickAndMortyCharacter>>(emptyList())
    val characters: StateFlow<List<RickAndMortyCharacter>> = _characters.asStateFlow()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val response = repository.getCharacters(1)
                _characters.value = response.results
            } catch (_: Exception) {
            }
        }
    }
}
