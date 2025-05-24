package dev.abhinav.runtracker

import android.app.Application
import android.os.Build
import dev.abhinav.auth.data.di.authDataModule
import dev.abhinav.auth.presentation.di.authViewModelModule
import dev.abhinav.core.data.di.coreDataModule
import dev.abhinav.run.location.di.locationModule
import dev.abhinav.run.presentation.di.runPresentationModule
import dev.abhinav.runtracker.di.appModule
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication : Application() {

    val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            // Initialize Timber for logging in debug mode
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                authDataModule,
                authViewModelModule,
                appModule,
                coreDataModule,
                runPresentationModule,
                locationModule
            )
        }
    }
}