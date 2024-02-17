package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.NetworkStatusHelper
import com.example.data.RickAndMortyAPI
import com.example.data.RickAndMortyRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logging
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
    fun provideNetworkStatusHelper(@ApplicationContext context: Context): NetworkStatusHelper {
        return NetworkStatusHelper(context)
    }

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.BODY
            }
            install(JsonFeature) {
                serializer = KotlinxSerializer(Json {
                    ignoreUnknownKeys = true // Игнорировать неизвестные ключи
                    isLenient = true // Более гибкая обработка JSON
                    encodeDefaults = true
                })
            }
        }
    }

    @Provides
    @Singleton
    fun provideRickAndMortyAPI(client: HttpClient): RickAndMortyAPI {
        return RickAndMortyAPI(client)
    }

    @Provides
    fun provideRickAndMortyRepository(api: RickAndMortyAPI): RickAndMortyRepository {
        return RickAndMortyRepository(api)
    }
}
