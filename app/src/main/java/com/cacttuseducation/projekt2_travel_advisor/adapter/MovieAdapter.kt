package com.cacttuseducation.projekt2_travel_advisor.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cacttuseducation.projekt2_travel_advisor.R
import com.cacttuseducation.projekt2_travel_advisor.ui.model.Result
import com.squareup.picasso.Picasso

class MovieAdapter(private val list: List<Result>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val cardView =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_details, parent, false)
        return MovieViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movies = list[position]
        holder.tvGenre.text = movies.genre.toString()
        holder.tvTitle.text = movies.title.toString()
//        holder.tvRelease.text = movies.released.toString()
        Picasso.get().load(movies?.imageurl?.getOrNull(0).toString()).into(holder.ivMovieImg);



        
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvGenre: TextView = itemView.findViewById(R.id.tvGenre)
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
//        val tvRelease: TextView = itemView.findViewById(R.id.tvRelease)
        val ivMovieImg: ImageView = itemView.findViewById(R.id.ivMovieImg)
    }
}