package com.example.emilin.androjet.repository

import android.telecom.Call
import com.example.emilin.androjet.models.User
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface UserService {

    @GET("login")
    fun getProjectList(@Query("email") email: String, @Query("password") password: String)  : Observable<User>

    companion object {
        val HTTPS_API_GITHUB_URL = "https://api.github.com/"
    }
}