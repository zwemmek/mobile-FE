package com.example.checkerapp.model

import com.google.gson.annotations.SerializedName

data class ServerResponse (

    @SerializedName("message")
    val message: String
)