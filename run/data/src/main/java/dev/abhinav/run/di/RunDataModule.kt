package dev.abhinav.run.di

import dev.abhinav.run.data.CreateRunWorker
import dev.abhinav.run.data.DeleteRunWorker
import dev.abhinav.run.data.FetchRunsWorker
import org.koin.androidx.workmanager.dsl.workerOf
import org.koin.dsl.module

val runDataModule = module {
    workerOf(::CreateRunWorker)
    workerOf(::DeleteRunWorker)
    workerOf(::FetchRunsWorker)
}