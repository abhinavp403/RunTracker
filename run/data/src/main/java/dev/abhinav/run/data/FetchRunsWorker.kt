package dev.abhinav.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dev.abhinav.core.domain.run.RunRepository
import dev.abhinav.core.domain.util.Result.*

class FetchRunsWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val runRepository: RunRepository
) : CoroutineWorker (context, workerParams) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }

        return when(val result = runRepository.fetchRuns()) {
            is Success -> Result.success()
            is Error -> {
                result.error.toWorkerResult()
            }
        }
    }
}