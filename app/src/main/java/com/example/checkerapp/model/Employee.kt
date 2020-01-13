package com.example.checkerapp.model

import com.google.gson.annotations.SerializedName

data class Employee (

    @SerializedName("employeeId")
    val employeeId: Long,

    @SerializedName("firstName")
    val firstName: String,

    @SerializedName("lastName")
    val lastName: String,

    @SerializedName("passId")
    val passId: Long,

    @SerializedName("password")
    val password: String
)