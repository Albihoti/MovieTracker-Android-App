package com.cacttuseducation.projekt2_travel_advisor.service

import com.cacttuseducation.projekt2_travel_advisor.ui.model.LoginRequestModel
import com.cacttuseducation.projekt2_travel_advisor.ui.model.RegisterRequestModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("users")
    fun register(@Body registerRequestModel: RegisterRequestModel): Call<RegisterRequestModel>


    @POST("users/login")
    fun login(@Body loginRequestModel: LoginRequestModel): Call<LoginRequestModel>
}