package com.example.data

import com.example.domain.CharactersResponse
import com.example.domain.IRickAndMortyAPI
import com.example.domain.IRickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepository @Inject constructor(
    private val api: IRickAndMortyAPI
) : IRickAndMortyRepository {

    private var currentPage = 1
    private var isLastPage = false

    override suspend fun getNextCharacters(): CharactersResponse? {
        if (isLastPage) return null

        val response = api.getCharacters(currentPage)
        if (response.results.isEmpty()) {
            isLastPage = true
            return null
        }
        currentPage++
        return response
    }

}
