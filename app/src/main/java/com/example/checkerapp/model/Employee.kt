package com.example.checkerapp.model

import com.google.gson.annotations.SerializedName

data class Employee (

    @SerializedName("employeeId")
    val employeeId: String,

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("passId")
    val passId: String,

    @SerializedName("password")
    val password: String
)