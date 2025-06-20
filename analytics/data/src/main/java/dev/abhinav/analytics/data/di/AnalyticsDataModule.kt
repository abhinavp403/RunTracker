package dev.abhinav.analytics.data.di

import dev.abhinav.analytics.data.RoomAnalyticsRepository
import dev.abhinav.analytics.domain.AnalyticsRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val analyticsModule = module {
    singleOf(::RoomAnalyticsRepository).bind<AnalyticsRepository>()
}