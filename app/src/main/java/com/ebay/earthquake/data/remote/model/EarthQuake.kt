package com.ebay.earthquake.data.remote.model

import com.squareup.moshi.Json

data class Feature(
    val properties: Properties,
    val geometry: Geometry,
    val id: String
)

data class Properties(
    val place: String,
    val title: String,
    val time: Long,
    val mag: Double
)

data class Geometry(
    val coordinates: List<Double>
)