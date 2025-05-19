package dev.abhinav.auth.presentation.login

import dev.abhinav.core.presentation.ui.UiText

sealed interface LoginEvent {
    data object LoginSuccess: LoginEvent
    data class Error(val error: UiText): LoginEvent
}