package com.designedbyz.covidreporter.di

import android.app.Application
import com.designedbyz.covidreporter.timessearch.NytSearchService
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
//import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
//import kotlinx.serialization.ExperimentalSerializationApi
//import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.squareup.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
//import kotlinx.serialization.json.JsonConfiguration
import okhttp3.Interceptor
import retrofit2.CallAdapter
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
class ApplicationModule {
    @Provides
    @ApplicationScope
    fun provideOkHttp(): OkHttpClient {

        return OkHttpClient()
    }

    //using retrofit to provide this service for speed. If I were working with a dedicated API I'd
    //normally want to put a customer wrapper(s) on top of OkHttp instead and use that to service
    //specific things, like retry logic, etc.
    //using Jackson as I am most familiar with it, and it's fast. It's also a great library if you're
    //into hand tuning parsers or have run into issues with runtime annotations being stripped out by
    //some oems.
    @Provides
    @ApplicationScope
    fun providesNytSearchService(okHttpClient: OkHttpClient): NytSearchService {
        val mapper = ObjectMapper()
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        mapper.registerModule(KotlinModule(nullToEmptyCollection = true, nullToEmptyMap = true, nullIsSameAsDefault = true))
        val retrofit = Retrofit.Builder().baseUrl(NytSearchService.url)
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory.create(mapper))
            .build()
        return retrofit.create(NytSearchService::class.java)
    }


    @Provides
    @ApplicationScope
    fun providesPicasso(application: Application, okHttpClient: OkHttpClient): Picasso {
        val picasso = Picasso.Builder(application).downloader(OkHttp3Downloader(okHttpClient)).build()
        Picasso.setSingletonInstance(picasso)
        return picasso
    }

    @Provides
    @ApplicationScope
    fun providesGoogleApiAvailability() : GoogleApiAvailability {
        return GoogleApiAvailability.getInstance()
    }

    @Provides
    fun providesLocationServices(application: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(application);
    }

}
