package dev.abhinav.core.domain.run

import dev.abhinav.core.domain.util.DataError
import dev.abhinav.core.domain.util.EmptyResult
import dev.abhinav.core.domain.util.Result

interface RemoteRunDataSource {
    suspend fun getRuns(): Result<List<Run>, DataError.Network>

    suspend fun postRun(run: Run, mapPicture: ByteArray): Result<Run, DataError.Network>

    suspend fun deleteRun(id: String): EmptyResult<DataError.Network>
}