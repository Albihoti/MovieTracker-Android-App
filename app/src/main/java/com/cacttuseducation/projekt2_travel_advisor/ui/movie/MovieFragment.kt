package com.cacttuseducation.projekt2_travel_advisor.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.cacttuseducation.projekt2_travel_advisor.adapter.MovieAdapter
import com.cacttuseducation.projekt2_travel_advisor.databinding.FragmentMovieBinding
import com.cacttuseducation.projekt2_travel_advisor.helpers.SingletonHelperObject
import com.cacttuseducation.projekt2_travel_advisor.ui.model.MovieResponse
import com.cacttuseducation.projekt2_travel_advisor.ui.home.HomeViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeApiCall()
        dosmth()
    }

    private fun dosmth() {
    }

    private fun makeApiCall() {
        val getMovies = SingletonHelperObject.provideRetrofitInstance().getMovies()


        getMovies.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                val listOfMovies = response.body()?.results
                binding.progressCircular.visibility = View.GONE
                val adapter = listOfMovies?.let { MovieAdapter(it) }
                binding.hRecycleView.layoutManager = LinearLayoutManager(requireContext())
                binding.hRecycleView.adapter = adapter
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.d("Log", t.message.toString())
            }
        })
    }




}