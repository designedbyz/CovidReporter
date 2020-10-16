package com.designedbyz.covidreporter.timessearch

import retrofit2.Callback
import javax.inject.Inject

const val apiKey = "81B8saucMehVmCzVo1q7viO3bwsMgtpg" //TODO better storage
class NytSearchUseCase @Inject constructor(private val searchService: NytSearchService) {

    //TODO: Get location with play services, geocode to a city, and pass that in .
    fun searchForCovidArticles(callback: Callback<Body>) { //TODO: add searching by location
        return searchService.getArticles("covid-19", "", apiKey).enqueue(callback)
    }
}
