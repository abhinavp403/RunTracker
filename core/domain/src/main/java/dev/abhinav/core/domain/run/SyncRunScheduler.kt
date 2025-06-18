package dev.abhinav.core.domain.run

import kotlin.time.Duration

interface SyncRunScheduler {

    suspend fun scheduleSync(type: SyncRun)
    suspend fun cancelAllSyncs()

    sealed interface SyncRun {
        data class FetchRuns(val interval: Duration) : SyncRun
        data class DeleteRun(val runId: String) : SyncRun
        class CreateRun(val run: Run, val mapPictureBytes: ByteArray) : SyncRun
    }
}