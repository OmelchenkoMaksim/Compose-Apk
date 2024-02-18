package com.example.data

import com.example.domain.CharactersResponse
import com.example.domain.IRickAndMortyAPI
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RickAndMortyAPI(private val client: HttpClient) : IRickAndMortyAPI {

    override suspend fun getCharacters(page: Int): CharactersResponse {
        println("Fetching characters for page: $page")
        try {
            val response: CharactersResponse = client.get<CharactersResponse>(
                "https://rickandmortyapi.com/api/character"
            ) {
                parameter("page", page)
            }

            println("Response: $response")
            return response
        } catch (e: Exception) {
            println("Error fetching characters: ${e.message}")
            throw e
        }
    }
}
