package com.example.s8173367assignment2.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
// Import your own custom data package models we created in Phase 2
import com.example.s8173367assignment2.data.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: AppRepository) : ViewModel() {

    private val _loginState = MutableStateFlow<State<LoginResponse>>(State.Initial)
    val loginState: StateFlow<State<LoginResponse>> = _loginState

    private val _dashboardState = MutableStateFlow<State<List<Entity>>>(State.Initial)
    val dashboardState: StateFlow<State<List<Entity>>> = _dashboardState

    fun login(request: LoginRequest) {
        viewModelScope.launch {
            _loginState.value = State.Loading
            try {
                val response = repository.login(request)
                _loginState.value = State.Success(response)
            } catch (e: Exception) {
                val errorMessage = e.localizedMessage ?: ""

                // FIXED: Intercepts the server's 404 response and rewrites it to a proper user message
                if (errorMessage.contains("400") || errorMessage.contains("404")) {
                    _loginState.value = State.Error("Incorrect Student ID or Password")
                } else {
                    _loginState.value = State.Error(errorMessage.ifEmpty { "Login Failed" })
                }
            }
        }
    }

    fun fetchDashboard(keypass: String) {
        viewModelScope.launch {
            _dashboardState.value = State.Loading
            try {
                val response = repository.getDashboardData(keypass)
                _dashboardState.value = State.Success(response.entities)
            } catch (e: Exception) {
                _dashboardState.value = State.Error(e.localizedMessage ?: "Failed to fetch data")
            }
        }
    }
}

// UI State Wrapper
sealed class State<out T> {
    object Initial : State<Nothing>()
    object Loading : State<Nothing>()
    data class Success<out T>(val data: T) : State<T>()
    data class Error(val message: String) : State<Nothing>()
}
