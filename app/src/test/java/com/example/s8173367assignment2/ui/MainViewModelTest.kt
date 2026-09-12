package com.example.s8173367assignment2.ui

import com.example.s8173367assignment2.MainDispatcherRule
import com.example.s8173367assignment2.data.DashboardResponse
import com.example.s8173367assignment2.data.Entity
import com.example.s8173367assignment2.data.FakeAppRepository
import com.example.s8173367assignment2.data.LoginRequest
import com.example.s8173367assignment2.data.LoginResponse
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var fakeRepository: FakeAppRepository
    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        fakeRepository = FakeAppRepository()
        viewModel = MainViewModel(fakeRepository)
    }

    @Test
    fun `login success updates loginState to Success`() = runTest {
        fakeRepository.loginResult = Result.success(LoginResponse(keypass = "abc123"))

        viewModel.login(LoginRequest("student", "password"))
        advanceUntilIdle()

        val state = viewModel.loginState.value
        assertTrue(state is State.Success)
        assertEquals("abc123", (state as State.Success).data.keypass)
    }

    @Test
    fun `login failure updates loginState to Error with friendly message`() = runTest {
        fakeRepository.loginResult = Result.failure(RuntimeException("HTTP 404"))

        viewModel.login(LoginRequest("student", "wrongpassword"))
        advanceUntilIdle()

        val state = viewModel.loginState.value
        assertTrue(state is State.Error)
        assertEquals("Incorrect Student ID or Password", (state as State.Error).message)
    }

    @Test
    fun `fetchDashboard success updates dashboardState with entities`() = runTest {
        val entities = listOf(
            Entity(titleField = "Inception", yearField = "2010", description = "A mind-bending thriller")
        )
        fakeRepository.dashboardResult = Result.success(DashboardResponse(entities = entities, entityTotal = 1))

        viewModel.fetchDashboard("abc123")
        advanceUntilIdle()

        val state = viewModel.dashboardState.value
        assertTrue(state is State.Success)
        assertEquals(1, (state as State.Success).data.size)
        assertEquals("Inception", state.data[0].property1)
    }

    @Test
    fun `fetchDashboard failure updates dashboardState to Error`() = runTest {
        fakeRepository.dashboardResult = Result.failure(RuntimeException("Network error"))

        viewModel.fetchDashboard("abc123")
        advanceUntilIdle()

        assertTrue(viewModel.dashboardState.value is State.Error)
    }

    @Test
    fun `loginState and dashboardState both start as Initial`() {
        assertTrue(viewModel.loginState.value is State.Initial)
        assertTrue(viewModel.dashboardState.value is State.Initial)
    }
}