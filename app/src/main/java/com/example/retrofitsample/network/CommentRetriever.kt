package com.example.retrofitsample.network

import com.example.retrofitsample.model.Comments
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentRetriever {
    private val networkInterface : NetworkInterface

    companion object {
        var BaseURl = "https://jsonplaceholder.typicode.com"
    }

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BaseURl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        networkInterface = retrofit.create(NetworkInterface::class.java)
    }

    suspend fun getComments() : List<Comments> {
        return networkInterface.getComments()
    }
}