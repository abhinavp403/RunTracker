package dev.abhinav.auth.data

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val accessToken: String,
    val refreshToken: String,
    val expirationTimestamp: Long,
    val userId: String
)
