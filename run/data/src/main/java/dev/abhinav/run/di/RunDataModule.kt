package dev.abhinav.run.di

import dev.abhinav.core.domain.run.SyncRunScheduler
import dev.abhinav.run.SyncRunWorkerScheduler
import dev.abhinav.run.data.CreateRunWorker
import dev.abhinav.run.data.DeleteRunWorker
import dev.abhinav.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::DeleteRunWorker)
    workerOf(::FetchRunsWorker)

    singleOf(::SyncRunWorkerScheduler).bind<SyncRunScheduler>()
}