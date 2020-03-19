package com.codekinian.themovieapps.view.main.tab.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.themovieapps.databinding.MovieItemBinding
import com.codekinian.themovieapps.model.data.Movie
import kotlinx.android.extensions.LayoutContainer

class MovieTabAdapter(
    private val movies: List<Movie>,
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MovieTabAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(movies[position])
    }

    inner class ViewHolder(private val view: MovieItemBinding) : RecyclerView.ViewHolder(view.root),
        LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(movie: Movie) {
            view.movie = movie

            containerView?.context.let {
                containerView?.setOnClickListener {
                    onClick(movie.id)
                }
            }
        }
    }
}