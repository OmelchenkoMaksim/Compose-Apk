package com.example.data

import com.example.domain.CharactersResponse
import com.example.domain.IRickAndMortyAPI
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse

class RickAndMortyAPI(private val client: HttpClient) : IRickAndMortyAPI {

    override suspend fun getCharacters(page: Int): CharactersResponse {
        println("Fetching characters for page: $page")
        try {
            val httpResponse: HttpResponse =
                client.get("https://rickandmortyapi.com/api/character") {
                    parameter("page", page)
                }
            val response: CharactersResponse = httpResponse.body()

            println("Response: $response")
            return response
        } catch (e: Exception) {
            println("Error fetching characters: ${e.message}")
            throw e
        }
    }
}
