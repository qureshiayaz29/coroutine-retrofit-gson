package com.example.retrofitsample.network

import com.example.retrofitsample.model.Comments
import retrofit2.http.GET

interface NetworkInterface {

    @GET("/comments")
    suspend fun getComments() : List<Comments>
}