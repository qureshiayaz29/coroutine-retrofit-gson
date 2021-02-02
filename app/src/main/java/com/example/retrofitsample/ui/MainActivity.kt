package com.example.retrofitsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitsample.R
import com.example.retrofitsample.model.Comments
import com.example.retrofitsample.network.CommentRetriever
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val commentRetriever : CommentRetriever = CommentRetriever()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerview()
        fetchComments()
    }

    private fun fetchComments() {

        val commentsFetchJob = Job()

        val errorHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            throwable.printStackTrace()
            Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
        }

        val scope = CoroutineScope(commentsFetchJob + Dispatchers.Main)

        scope.launch(errorHandler){

            //fetched data
            val commentResponse = commentRetriever.getComments()

            //render data in recyclerview
            renderData(commentResponse)
        }
    }

    private fun renderData(commentResponse: List<Comments>) {
        recyclerview.adapter = CommentsAdapter(commentResponse = commentResponse)
    }

    private fun initRecyclerview() {
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}