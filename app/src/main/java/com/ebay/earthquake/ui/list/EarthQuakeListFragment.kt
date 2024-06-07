package com.ebay.earthquake.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebay.earthquake.databinding.EarthQuakeListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EarthQuakeListFragment : Fragment() {

    private val viewModel by viewModels<EarthQuakeListViewModel>()

    private var _binding: EarthQuakeListFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: EarthQuakeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = EarthQuakeListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        observeEarthquakes()
    }

    private fun setupAdapter() {
        adapter = EarthQuakeAdapter {
        }
        binding.earthQuakeList.adapter = adapter
    }

    private fun observeEarthquakes() {
        GlobalScope.launch {
            viewModel.modelState.collect { state ->
                adapter.submitList(state)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}