package com.example.s8173367assignment2.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun login(request: LoginRequest) = apiService.login(request)
    suspend fun getDashboardData(keypass: String) = apiService.getDashboard(keypass)
}