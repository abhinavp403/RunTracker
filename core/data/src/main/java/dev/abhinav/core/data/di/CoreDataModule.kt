package dev.abhinav.core.data.di

import dev.abhinav.core.data.auth.EncryptedSessionStorage
import org.koin.dsl.module
import dev.abhinav.core.data.networking.HttpClientFactory
import dev.abhinav.core.data.run.OfflineFirstRunRepository
import dev.abhinav.core.domain.SessionStorage
import dev.abhinav.core.domain.run.RunRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val coreDataModule = module {
    single {
        HttpClientFactory(get()).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()

    singleOf(::OfflineFirstRunRepository).bind<RunRepository>()
}