package com.example.s8173367assignment2.data

class AppRepository(private val apiService: ApiService) {
    suspend fun login(request: LoginRequest) = apiService.login(request)
    suspend fun getDashboardData(keypass: String) = apiService.getDashboard(keypass)
}