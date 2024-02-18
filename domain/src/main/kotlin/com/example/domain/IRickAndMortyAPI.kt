package com.example.domain

interface IRickAndMortyAPI {
    suspend fun getCharacters(page: Int): CharactersResponse
}