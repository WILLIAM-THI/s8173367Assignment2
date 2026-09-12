package com.example.s8173367assignment2.data

class FakeAppRepository : AppRepository {
    var loginResult: Result<LoginResponse>? = null
    var dashboardResult: Result<DashboardResponse>? = null

    override suspend fun login(request: LoginRequest): LoginResponse {
        return loginResult?.getOrThrow() ?: error("loginResult not set for this test")
    }

    override suspend fun getDashboardData(keypass: String): DashboardResponse {
        return dashboardResult?.getOrThrow() ?: error("dashboardResult not set for this test")
    }
}