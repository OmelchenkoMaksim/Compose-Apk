package com.example.domain

import kotlinx.coroutines.flow.Flow

interface INetworkStatusHelper {
    fun observeNetworkStatus(): Flow<Boolean>
}