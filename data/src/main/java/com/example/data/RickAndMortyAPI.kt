package com.example.data

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.serialization.Serializable

class RickAndMortyAPI(private val client: HttpClient) {

    suspend fun getCharacters(page: Int): CharactersResponse {
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

@Serializable
data class CharactersResponse(
    val info: Info,
    val results: List<RickAndMortyCharacter>
)

@Serializable
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)

@Serializable
data class RickAndMortyCharacter(
    val name: String,
    val status: String,
    val species: String,
    val image: String
)
