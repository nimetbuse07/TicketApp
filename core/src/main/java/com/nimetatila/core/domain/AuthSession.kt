package com.nimetatila.core.domain

data class AuthSession(val user: User, val accessToken: String, val refreshToken: String) {}