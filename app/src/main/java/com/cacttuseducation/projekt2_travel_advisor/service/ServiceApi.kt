package com.cacttuseducation.projekt2_travel_advisor.service

import android.content.Context
import com.cacttuseducation.projekt2_travel_advisor.ui.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ServiceApi {
    @Headers(
        value = [
            "X-RapidAPI-Key:950bfc5730msh9d869989c88f97fp1f48e3jsn8f68a97819c1",
            "X-RapidAPI-Host: ott-details.p.rapidapi.com"
        ]
    )


    @GET("advancedsearch")
    fun getMovies():Call<MovieResponse>

}