package dev.abhinav.core.data.networking.di

import org.koin.dsl.module
import dev.abhinav.core.data.networking.HttpClientFactory

val coreDataModule = module {
    single {
        HttpClientFactory().build()
    }
}