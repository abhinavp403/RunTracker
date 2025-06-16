package dev.abhinav.run.presentation.run_overview

import dev.abhinav.run.presentation.run_overview.model.RunUi

data class RunOverviewState(
    val runs: List<RunUi> = emptyList(),
)
