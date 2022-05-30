package com.zotreex.sample_project.di

import com.zotreex.sample_project.domain.api.PhoneSpecificationsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
class NetworkModule {
    @Provides
    fun providePhoneSpecificationsApi(): PhoneSpecificationsService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api-mobilespecs.azharimm.site/v2/")
            .build()
        return retrofit.create()
    }
}