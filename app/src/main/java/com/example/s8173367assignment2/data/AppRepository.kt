package com.example.s8173367assignment2.data

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import com.example.s8173367assignment2.di.IoDispatcher
import javax.inject.Inject
import javax.inject.Singleton

interface AppRepository {
    suspend fun login(request: LoginRequest): LoginResponse
    suspend fun getDashboardData(keypass: String): DashboardResponse
}

@Singleton
class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
) : AppRepository {
    override suspend fun login(request: LoginRequest) = withContext(dispatcher) {
        apiService.login(request)
    }
    override suspend fun getDashboardData(keypass: String) = withContext(dispatcher) {
        apiService.getDashboard(keypass)
    }
}