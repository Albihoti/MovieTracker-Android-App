package com.cacttuseducation.projekt2_travel_advisor.ui.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cacttuseducation.projekt2_travel_advisor.R
import com.cacttuseducation.projekt2_travel_advisor.databinding.FragmentFavoriteBinding
import com.cacttuseducation.projekt2_travel_advisor.databinding.FragmentHomeBinding

class FavoriteFragment : Fragment() {


    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getFavorites()
    }

    private fun getFavorites() {
//        val favorites = arguments.toString()
//
//        if (favorites != null) {
//            if (!favorites.isEmpty()) {
//
//           binding.tvFav.text=favorites
//
//            }
//
//
//            }
    }


}