package com.example.emilin.androjet.repository

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class UserServiceImpl {

    companion object {
        internal fun getWebService() : UserService{
            return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://localhost:9000/WebServices/ema/")
                .build()
                .create(UserService::class.java)
        }
    }
}