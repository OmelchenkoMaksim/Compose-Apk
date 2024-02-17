package com.example.domain

import kotlinx.serialization.Serializable

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
    val image: String?
)

