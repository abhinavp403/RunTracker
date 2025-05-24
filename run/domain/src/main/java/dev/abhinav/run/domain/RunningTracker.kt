@file:OptIn(ExperimentalCoroutinesApi::class)
package dev.abhinav.run.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn

class RunningTracker(
    private val locationObserver: LocationObserver,
    private val applicationScope: CoroutineScope
) {

    private val isObservingLocation = MutableStateFlow(false)

    val currentLocation = isObservingLocation
        .flatMapLatest { isObservingLocation->  //map the outcome of receiving flow to different flows based on the state of isObservingLocation
            if (isObservingLocation) {
                locationObserver.observeLocation(1000L)
            } else {
                flowOf()
            }
        }.stateIn(applicationScope, SharingStarted.Lazily, null)

    fun startObservingLocation() {
        isObservingLocation.value = true
    }

    fun stopObservingLocation() {
        isObservingLocation.value = false
    }
}