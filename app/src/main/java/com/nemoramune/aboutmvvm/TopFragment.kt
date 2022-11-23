package com.nemoramune.aboutmvvm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.nemoramune.aboutmvvm.databinding.FragmentTopBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class TopFragment: Fragment(R.layout.fragment_top) {

    private val viewModel: TopViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTopBinding.bind(view)
        val imageView = binding.imageView
        viewModel.imageUrlLiveData.observe(viewLifecycleOwner) { imageUrl ->
            Glide.with(imageView)
                .load(imageUrl)
                .into(imageView)
        }
        viewModel.errorFlow.onEach {
            Snackbar.make(view, "エラーしました！", Snackbar.LENGTH_SHORT).show()
        }.launchIn(viewLifecycleOwner.lifecycleScope)
        viewModel.fetch()

        binding.button.setOnClickListener {
            viewModel.fetch()
        }
    }
}