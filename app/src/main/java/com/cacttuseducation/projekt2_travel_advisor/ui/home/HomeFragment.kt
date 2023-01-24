package com.cacttuseducation.projekt2_travel_advisor.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.cacttuseducation.projekt2_travel_advisor.R
import com.cacttuseducation.projekt2_travel_advisor.databinding.FragmentHomeBinding
import com.cacttuseducation.projekt2_travel_advisor.helpers.SingletonHelperObject

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToMoviePage()

    }


    private fun goToMoviePage() {
        binding.outlinedButton.setOnClickListener {
            val checkLogin =
                SingletonHelperObject.getBooleanFromSharedPrefs(requireContext(), "isLogged")
            if (checkLogin?.equals(true) == true) {

                findNavController().navigate(R.id.action_nav_home_to_nav_movies)
            } else {
                findNavController().navigate(R.id.action_nav_home_to_nav_login)
            }
        }
    }
}