package dev.abhinav.core.data.auth

import dev.abhinav.core.domain.AuthInfo

fun AuthInfo.toAuthInfoSerializable(): AuthInfoSerializable {
    return AuthInfoSerializable(
        accessToken = accessToken,
        refreshToken = refreshToken,
        userId = userId,
    )
}

fun AuthInfoSerializable.toAuthInfo(): AuthInfo {
    return AuthInfo(
        accessToken = accessToken,
        refreshToken = refreshToken,
        userId = userId,
    )
}