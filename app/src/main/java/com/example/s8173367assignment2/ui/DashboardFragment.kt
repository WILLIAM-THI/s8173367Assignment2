package com.example.s8173367assignment2.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.s8173367assignment2.R
import com.example.s8173367assignment2.data.AppRepository
import com.example.s8173367assignment2.data.RetrofitClient
import com.example.s8173367assignment2.databinding.FragmentDashboardBinding
import kotlinx.coroutines.launch

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var binding: FragmentDashboardBinding
    private val args: DashboardFragmentArgs by navArgs()
    private val viewModel = MainViewModel(AppRepository(RetrofitClient.apiService))
    private lateinit var adapter: EntityAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDashboardBinding.bind(view)

        adapter = EntityAdapter { entity ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(entity)
            findNavController().navigate(action)
        }
        binding.recyclerView.adapter = adapter

        // Fetch using safe args keypass context
        viewModel.fetchDashboard(args.keypass)

        lifecycleScope.launch {
            viewModel.dashboardState.collect { state ->
                when (state) {
                    is State.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is State.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapter.updateData(state.data)
                    }
                    is State.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                    }
                    else -> binding.progressBar.visibility = View.GONE
                }
            }
        }
    }
}
