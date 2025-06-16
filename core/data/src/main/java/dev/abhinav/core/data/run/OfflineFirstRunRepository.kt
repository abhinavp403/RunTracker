package dev.abhinav.core.data.run

import dev.abhinav.core.domain.run.LocalRunDataSource
import dev.abhinav.core.domain.run.RemoteRunDataSource
import dev.abhinav.core.domain.run.Run
import dev.abhinav.core.domain.run.RunId
import dev.abhinav.core.domain.run.RunRepository
import dev.abhinav.core.domain.util.DataError
import dev.abhinav.core.domain.util.EmptyResult
import dev.abhinav.core.domain.util.Result
import dev.abhinav.core.domain.util.asEmptyDataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow

class OfflineFirstRunRepository(
    private val localRunDataSource: LocalRunDataSource,
    private val remoteRunDataSource: RemoteRunDataSource,
    private val applicationScope: CoroutineScope
) : RunRepository {
    override fun getRuns(): Flow<List<Run>> {
        return localRunDataSource.getRuns()
    }

    override suspend fun fetchRuns(): EmptyResult<DataError> {
        return when(val result = remoteRunDataSource.getRuns()) {
            is Result.Success -> {
               applicationScope.async {
                   localRunDataSource.upsertRuns(result.data).asEmptyDataResult()
               }.await()
            }
            is Result.Error -> {
                result.asEmptyDataResult()
            }
        }
    }

    override suspend fun upsertRun(run: Run, mapPicture: ByteArray): EmptyResult<DataError> {
        val localResult = localRunDataSource.upsertRun(run)
        if (localResult !is Result.Success) {
            return localResult.asEmptyDataResult()
        }

        val runWithId = run.copy(id = localResult.data)
        val remoteResult = remoteRunDataSource.postRun(
            run = runWithId,
            mapPicture = mapPicture
        )

        return when(remoteResult) {
            is Result.Success -> {
                applicationScope.async {
                    localRunDataSource.upsertRun(remoteResult.data).asEmptyDataResult()
                }.await()
            }
            is Result.Error -> {
                Result.Success(Unit)
            }
        }
    }

    override suspend fun deleteRun(id: RunId) {
        localRunDataSource.deleteRun(id)

        val remoteResult = applicationScope.async {
            remoteRunDataSource.deleteRun(id)
        }.await()
    }
}