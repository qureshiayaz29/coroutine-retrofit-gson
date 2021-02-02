package com.example.retrofitsample.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitsample.R
import com.example.retrofitsample.model.Comments
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentsAdapter(private val commentResponse: List<Comments>) : RecyclerView.Adapter<CommentsAdapter.ViewHolder>() {

    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bind(comment : Comments){

            itemView.name.text = comment.name
            itemView.email.text = comment.email
            itemView.body.text = comment.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(view = LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(comment = commentResponse.get(position))
    }

    override fun getItemCount(): Int = commentResponse.size
}