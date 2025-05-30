package dev.abhinav.auth.presentation.di

import dev.abhinav.auth.presentation.login.LoginViewModel
import dev.abhinav.auth.presentation.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}