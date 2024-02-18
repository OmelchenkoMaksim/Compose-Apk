package com.example.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.INetworkStatusHelper
import com.example.domain.IRickAndMortyRepository
import com.example.domain.RickAndMortyCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RickAndMortyScreenViewModel @Inject constructor(
    private val repository: IRickAndMortyRepository,
    private val networkStatusHelper: INetworkStatusHelper
) : ViewModel() {

    private val _characters = MutableStateFlow<List<RickAndMortyCharacter>>(emptyList())
    val characters: StateFlow<List<RickAndMortyCharacter>> = _characters.asStateFlow()

    init {
        observeNetworkStatus()
        loadNextPage()
    }

    fun loadNextPage() {
        viewModelScope.launch {
            repository.getNextCharacters()?.let {
                _characters.value = _characters.value + it.results
            }
        }
    }

    private fun observeNetworkStatus() {
        viewModelScope.launch {
            (networkStatusHelper.observeNetworkStatus() as Flow<Boolean>).collect { isAvailable ->
                if (isAvailable && _characters.value.isEmpty()) {
                    loadNextPage()
                }
            }
        }
    }
}
