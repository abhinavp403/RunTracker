package dev.abhinav.auth.domain

import dev.abhinav.core.domain.util.DataError
import dev.abhinav.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
}