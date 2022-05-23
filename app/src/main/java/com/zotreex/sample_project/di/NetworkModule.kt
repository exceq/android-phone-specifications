package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.api.SampleService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {
    @Provides
    fun provideSampleApi(): SampleService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.sampleapi.com/")
            .build()
        return retrofit.create()
    }
}