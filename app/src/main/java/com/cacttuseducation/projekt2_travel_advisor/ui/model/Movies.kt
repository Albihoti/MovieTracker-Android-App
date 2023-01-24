package com.cacttuseducation.projekt2_travel_advisor.ui.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("page") var page: Int?,
    @SerializedName("results") var results: List<Result>

)

data class Result(

    @SerializedName("genre") var genre: List<String>,
    @SerializedName("imageurl") var imageurl: List<String>,
    @SerializedName("imdbid") var imdbid: String?,
    @SerializedName("imdbrating") var imdbrating: Double?,
    @SerializedName("released") var released: Int,
    @SerializedName("synopsis") var synopsis: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("type") var type: String?

)