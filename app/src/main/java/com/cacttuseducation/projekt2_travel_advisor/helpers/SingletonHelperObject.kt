package com.cacttuseducation.projekt2_travel_advisor.helpers

import android.content.Context
import android.content.SharedPreferences
import com.cacttuseducation.projekt2_travel_advisor.service.AuthenticationApi
import com.cacttuseducation.projekt2_travel_advisor.service.ServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SingletonHelperObject {


    private const val SHARED_PREFS_NAME = "app_shared_preferences"

    fun provideRetrofitInstanceForAuthentication(): AuthenticationApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://localhost:3000/")
            .build()
            .create(AuthenticationApi::class.java)
    }


    fun provideRetrofitInstance(): ServiceApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://ott-details.p.rapidapi.com/")
            .build()
            .create(ServiceApi::class.java)
    }


    private fun provideSharedPrefsInstance(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            SHARED_PREFS_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun putBooleanOnSharedPrefs(context: Context, key: String, value: Boolean) {
        provideSharedPrefsInstance(context).edit().apply() {
            putBoolean(key, value).apply()
        }
    }


    fun getBooleanFromSharedPrefs(context: Context, key: String): Boolean? {
        return provideSharedPrefsInstance(context).getBoolean(key, false)
    }


    fun putStringToSharedPrefs(context: Context, key: String, value: String) {
        provideSharedPrefsInstance(context).edit().apply() {
            putString(key, value).apply()
        }
    }

    fun getStringFromSharedPrefs(context: Context, key: String): String? {
        return provideSharedPrefsInstance(context).getString(key, "")
    }


}
