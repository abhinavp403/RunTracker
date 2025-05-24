package dev.abhinav.run.presentation.active_run

import dev.abhinav.core.domain.location.Location
import dev.abhinav.run.domain.RunData
import kotlin.time.Duration

data class ActiveRunState (
    val elapsedTime: Duration = Duration.ZERO,
    val runData: RunData = RunData(),
    val shouldTrack: Boolean = false,
    val hasStartedRunning: Boolean = false,
    val currentLocation: Location? = null,
    val isRunFinished: Boolean = false,
    val isSavingRun: Boolean = false,
    val showLocationRationale: Boolean = false,
    val showNotificationRationale: Boolean = false
)