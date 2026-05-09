package com.nimetatila.data.repository

import com.nimetatila.core.domain.AuthRepository
import com.nimetatila.core.domain.AuthSession
import com.nimetatila.core.domain.User
import com.nimetatila.core.domain.UserRole
import com.nimetatila.data.dto.CredentialsDto
import com.nimetatila.data.remote.AuthApi
import com.nimetatila.data.util.runCatchingApi
import kotlinx.coroutines.flow.Flow

class AuthRepositoryImpl(
    private val authApi: AuthApi
) : AuthRepository {
    override val isLoggedIn: Flow<Boolean>
        get() = TODO("Not yet implemented")

    override suspend fun login(
        email: String,
        password: String
    ): Result<AuthSession> = runCatchingApi {
        authApi.login(CredentialsDto(email=email, password=password))
    }.onSuccess {
        // jwt'i bi yere yaz..
    }
        .map {
                i -> AuthSession(
            user = User(
                i.user.id, i.user.email, UserRole.fromApi(i.user.role),
            ),
            accessToken = i.accessToken,
            refreshToken = i.refreshToken)
        }


    override suspend fun register(
        email: String,
        password: String
    ): Result<AuthSession> {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Result<Unit> {
        TODO("Not yet implemented")
    }
}