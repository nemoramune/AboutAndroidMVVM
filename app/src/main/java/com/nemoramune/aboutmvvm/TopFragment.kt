package com.nemoramune.aboutmvvm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.nemoramune.aboutmvvm.databinding.FragmentTopBinding

class TopFragment: Fragment(R.layout.fragment_top) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentTopBinding.bind(view)
        val imageView = binding.imageView
        val imageUrl = "https://foodish-api.herokuapp.com/images/pizza/pizza50.jpg"
        Glide.with(imageView)
            .load(imageUrl)
            .into(imageView)
    }
}