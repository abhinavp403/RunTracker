package dev.abhinav.auth.data.di

import dev.abhinav.auth.data.EmailPatternValidator
import org.koin.dsl.module
import dev.abhinav.auth.domain.PatternValidator
import dev.abhinav.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
}