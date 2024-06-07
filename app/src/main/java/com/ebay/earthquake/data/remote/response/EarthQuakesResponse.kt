package com.ebay.earthquake.data.remote.response

import com.ebay.earthquake.data.remote.model.Feature

data class EarthQuakesResponse(
    val features: List<Feature>
)