package dev.abhinav.auth.data

import dev.abhinav.auth.domain.AuthRepository
import dev.abhinav.core.data.networking.post
import dev.abhinav.core.domain.util.DataError
import dev.abhinav.core.domain.util.EmptyResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(private val httpClient: HttpClient) : AuthRepository {

    override suspend fun register(email: String, password: String): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )
    }
}