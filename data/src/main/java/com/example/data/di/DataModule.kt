package com.example.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.data.NetworkStatusHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
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
}
