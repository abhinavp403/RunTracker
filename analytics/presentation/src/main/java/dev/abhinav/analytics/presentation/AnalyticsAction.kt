package dev.abhinav.analytics.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}