package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.NetworkStatusHelper
import com.example.data.RickAndMortyAPI
import com.example.data.RickAndMortyRepository
import com.example.domain.INetworkStatusHelper
import com.example.domain.IRickAndMortyAPI
import com.example.domain.IRickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("compose_app_prefs", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideNetworkStatusHelper(@ApplicationContext context: Context): INetworkStatusHelper {
        return NetworkStatusHelper(context)
    }

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.BODY
            }
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = true
                })
            }
        }
    }


    @Provides
    @Singleton
    fun provideRickAndMortyAPI(client: HttpClient): IRickAndMortyAPI {
        return RickAndMortyAPI(client)
    }

    @Provides
    @Singleton
    fun provideRickAndMortyRepository(api: IRickAndMortyAPI): IRickAndMortyRepository {
        return RickAndMortyRepository(api)
    }
}
