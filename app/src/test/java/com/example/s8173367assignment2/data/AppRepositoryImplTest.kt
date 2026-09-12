package com.example.s8173367assignment2.data

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class AppRepositoryImplTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var apiService: ApiService
    private lateinit var repository: AppRepositoryImpl

    @Before
    fun setup() {
        apiService = mockk()
        repository = AppRepositoryImpl(apiService, testDispatcher)
    }

    @Test
    fun `login delegates to apiService and returns its result`() = runTest(testDispatcher) {
        val request = LoginRequest("student", "password")
        val expectedResponse = LoginResponse(keypass = "abc123")
        coEvery { apiService.login(request) } returns expectedResponse

        val result = repository.login(request)

        assertEquals(expectedResponse, result)
    }

    @Test
    fun `getDashboardData delegates to apiService with correct keypass`() = runTest(testDispatcher) {
        val expectedResponse = DashboardResponse(
            entities = listOf(Entity(titleField = "Inception", description = "desc")),
            entityTotal = 1
        )
        coEvery { apiService.getDashboard("abc123") } returns expectedResponse

        val result = repository.getDashboardData("abc123")

        assertEquals(expectedResponse, result)
    }
}