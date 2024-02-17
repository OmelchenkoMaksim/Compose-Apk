package com.example.data

import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(private val api: RickAndMortyAPI) {

    suspend fun getCharacters(page: Int): CharactersResponse {
        return api.getCharacters(page)
    }
}
