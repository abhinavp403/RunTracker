package dev.abhinav.run.presentation.di

import dev.abhinav.run.domain.RunningTracker
import dev.abhinav.run.presentation.active_run.ActiveRunViewModel
import dev.abhinav.run.presentation.run_overview.RunOverviewViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val runPresentationModule = module {
    singleOf(::RunningTracker)

    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}