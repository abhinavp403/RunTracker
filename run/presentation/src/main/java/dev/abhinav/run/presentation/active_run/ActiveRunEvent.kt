package dev.abhinav.run.presentation.active_run

import dev.abhinav.core.presentation.ui.UiText

sealed interface ActiveRunEvent {
    data class Error(val error: UiText): ActiveRunEvent
    data object RunSaved: ActiveRunEvent
}