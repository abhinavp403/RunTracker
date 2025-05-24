package dev.abhinav.run.location.di

import dev.abhinav.run.domain.LocationObserver
import dev.abhinav.run.location.AndroidLocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}