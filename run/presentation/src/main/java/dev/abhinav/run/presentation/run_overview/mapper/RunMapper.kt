package dev.abhinav.run.presentation.run_overview.mapper

import dev.abhinav.core.domain.run.Run
import dev.abhinav.core.presentation.ui.formatted
import dev.abhinav.core.presentation.ui.toFormattedKm
import dev.abhinav.core.presentation.ui.toFormattedKmh
import dev.abhinav.core.presentation.ui.toFormattedMeters
import dev.abhinav.core.presentation.ui.toFormattedPace
import dev.abhinav.run.presentation.run_overview.model.RunUi
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun Run.toRunUi(): RunUi {
    val dateTimeInLocalTime = dateTimeUtc
        .withZoneSameInstant(ZoneId.systemDefault())
    val formattedDateTime = DateTimeFormatter
        .ofPattern("MMM dd, yyyy - hh:mma")
        .format(dateTimeInLocalTime)

    val distanceKm = distanceMeters / 1000.0

    return RunUi(
        id = id!!,
        duration = duration.formatted(),
        dateTime = formattedDateTime,
        distance = distanceKm.toFormattedKm(),
        avgSpeed = avgSpeedKmh.toFormattedKmh(),
        maxSpeed = maxSpeedKmh.toFormattedKmh(),
        pace = duration.toFormattedPace(distanceKm),
        totalElevation = totalElevationMeters.toFormattedMeters(),
        mapPictureUrl = mapPictureUrl
    )
}