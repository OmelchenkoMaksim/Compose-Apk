package com.example.domain

interface IRickAndMortyRepository {
    suspend fun getNextCharacters(): CharactersResponse?
}
