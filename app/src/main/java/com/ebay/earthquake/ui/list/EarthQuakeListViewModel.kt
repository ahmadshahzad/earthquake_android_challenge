package com.ebay.earthquake.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ebay.earthquake.data.remote.EarthQuakeApi
import com.ebay.earthquake.data.remote.model.Feature
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EarthQuakeListViewModel @Inject constructor(private val api: EarthQuakeApi) : ViewModel() {

    val modelState = MutableStateFlow<List<Feature>>(emptyList())

    init {
        fetchEarthQuakes()
    }

    private fun fetchEarthQuakes () {
        viewModelScope.launch {
            try {
                val response = api.getEarthquakes()
                val earthQuakesList = response.features
                modelState.value = earthQuakesList
            } catch (exception: Exception) {
                // TODO: Handle Error
            }
        }
    }
}