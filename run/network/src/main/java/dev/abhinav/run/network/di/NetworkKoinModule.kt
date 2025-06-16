package dev.abhinav.run.network.di

import dev.abhinav.core.domain.run.RemoteRunDataSource
import dev.abhinav.run.network.KtorRemoteRunDataSource
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val networkModule = module {
    singleOf(::KtorRemoteRunDataSource).bind<RemoteRunDataSource>()
}