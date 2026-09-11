package com.example.s8173367assignment2.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.s8173367assignment2.R
import com.example.s8173367assignment2.data.LoginRequest
import com.example.s8173367assignment2.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            binding.tvErrorMessage.visibility = View.GONE
            viewModel.login(LoginRequest(username, password))
        }

        lifecycleScope.launch {
            viewModel.loginState.collect { state ->
                when (state) {
                    is State.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is State.Success -> {
                        binding.progressBar.visibility = View.GONE
                        val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(state.data.keypass)
                        findNavController().navigate(action)
                    }
                    is State.Error -> {
                        binding.progressBar.visibility = View.GONE
                        binding.tvErrorMessage.text = state.message
                        binding.tvErrorMessage.visibility = View.VISIBLE
                    }
                    else -> binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}