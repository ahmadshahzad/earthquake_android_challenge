package com.ebay.earthquake.data.remote

import com.ebay.earthquake.data.remote.response.EarthQuakesResponse
import retrofit2.http.GET

interface EarthQuakeApi {
    @GET("earthquakes")
    suspend fun getEarthquakes(): EarthQuakesResponse
}