package com.example.data

import com.example.domain.CharactersResponse
import com.example.domain.IRickAndMortyAPI
import com.example.domain.Info
import com.example.domain.RickAndMortyCharacter
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class RickAndMortyRepositoryTest {

    private lateinit var repository: RickAndMortyRepository
    private lateinit var fakeApi: FakeRickAndMortyAPI

    @Before
    fun setUp() {
        fakeApi = FakeRickAndMortyAPI()
        repository = RickAndMortyRepository(fakeApi)
    }

    @Test
    fun `getNextCharacters returns characters when API call is successful`() = runTest {
        val expectedCharacters = listOf(
            RickAndMortyCharacter(name = "Rick Sanchez", status = "Alive", species = "Human", null),
            RickAndMortyCharacter(name = "Morty Smith", status = "Alive", species = "Human", null)
        )
        fakeApi.response = CharactersResponse(
            info = Info(count = 2, pages = 1, next = null, prev = null),
            results = expectedCharacters
        )

        val result = repository.getNextCharacters()

        assertEquals(expectedCharacters, result?.results)
    }

    @Test
    fun `getNextCharacters returns null when API call reaches last page`() = runTest {
        fakeApi.response = CharactersResponse(
            info = Info(count = 2, pages = 1, next = null, prev = null),
            results = emptyList()
        )

        val result = repository.getNextCharacters()

        assertNull(result)
    }
}

private class FakeRickAndMortyAPI : IRickAndMortyAPI {
    var response: CharactersResponse? = null
    var exception: Exception? = null

    override suspend fun getCharacters(page: Int): CharactersResponse {
        exception?.let { throw it }
        return response ?: throw RuntimeException("Response not set")
    }
}
