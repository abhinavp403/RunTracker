package dev.abhinav.run.location

import android.location.Location
import dev.abhinav.core.domain.location.LocationWithAltitude

fun Location.toLocationWithAltitude(): LocationWithAltitude {
    return LocationWithAltitude(
        location = dev.abhinav.core.domain.location.Location(
            lat = latitude,
            long = longitude
        ),
        altitude = altitude
    )
}