package com.designedbyz.covidreporter.timessearch

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NytSearchService {

    companion object {
        const val url = "https://api.nytimes.com"
    }

    @GET(value = "/svc/search/v2/articlesearch.json")
    fun getArticles(@Query("q") query: String,
                    @Query("fq") filterQuery: String,
                    @Query("api-key") apiKey: String): Call<Body>
}
