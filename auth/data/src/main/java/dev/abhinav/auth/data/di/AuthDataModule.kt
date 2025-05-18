package dev.abhinav.auth.data.di

import dev.abhinav.auth.data.EmailPatternValidator
import dev.abhinav.auth.data.AuthRepositoryImpl
import dev.abhinav.auth.domain.AuthRepository
import org.koin.dsl.module
import dev.abhinav.auth.domain.PatternValidator
import dev.abhinav.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }
    singleOf(::UserDataValidator)
    singleOf(::AuthRepositoryImpl).bind<AuthRepository>()
}