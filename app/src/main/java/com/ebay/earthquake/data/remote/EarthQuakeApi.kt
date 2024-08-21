package com.ebay.earthquake.data.remote

import com.ebay.earthquake.data.remote.response.EarthQuakesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface EarthQuakeApi {
    @GET("earthquakes")
    suspend fun getEarthquakes(
        @Query("starttime") startTime: String = "2024-01-03",
        @Query("endtime") endTime: String = "2024-01-04"
    ): EarthQuakesResponse
}