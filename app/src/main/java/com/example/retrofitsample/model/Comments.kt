package com.example.retrofitsample.model

data class Comments (
    val postId : Long = 0,
    val id : Long = 0,
    val name : String = "",
    val email : String = "",
    val body : String = "",
)