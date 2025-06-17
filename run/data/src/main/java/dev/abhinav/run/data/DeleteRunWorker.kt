package dev.abhinav.run.data

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import dev.abhinav.core.database.dao.RunPendingSyncDao
import dev.abhinav.core.database.mappers.toRun
import dev.abhinav.core.domain.run.RemoteRunDataSource
import dev.abhinav.core.domain.util.Result.Success
import dev.abhinav.core.domain.util.Result.Error

class DeleteRunWorker(
    context: Context,
    private val workerParams: WorkerParameters,
    private val remoteRunDataSource: RemoteRunDataSource,
    private val pendingSyncDao: RunPendingSyncDao
) : CoroutineWorker (context, workerParams) {

    override suspend fun doWork(): Result {
        if (runAttemptCount >= 5) {
            return Result.failure()
        }

        val pendingRunId = workerParams.inputData.getString(RUN_ID) ?: return Result.failure()
        val pendingRunEntity = pendingSyncDao.getRunPendingSyncEntity(pendingRunId) ?: return Result.failure()

        val run = pendingRunEntity.run.toRun()
        return when(val result = remoteRunDataSource.postRun(run, pendingRunEntity.mapPictureBytes)) {
            is Success -> {
                pendingSyncDao.deleteDeletedRunSyncEntity(pendingRunId)
                Result.success()
            }
            is Error -> {
                result.error.toWorkerResult()
            }
        }
    }

    companion object {
        const val RUN_ID = "RUN_ID"
    }
}