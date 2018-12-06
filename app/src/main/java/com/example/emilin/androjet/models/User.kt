package com.example.emilin.androjet.models

import com.google.gson.annotations.SerializedName

data class User (@field:SerializedName("id") val id : Int,
                 @field:SerializedName("firstName") val firstName : String,
                 @field:SerializedName("lastName")val lastName : String,
                 @field:SerializedName("email") val email : String,
                 @field:SerializedName("password") val password: String){
}