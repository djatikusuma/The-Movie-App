package com.codekinian.themovieapps.view.main.tab.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.themovieapps.databinding.MovieItemBinding
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.utils.DateUtils
import com.codekinian.themovieapps.utils.Helpers
import kotlinx.android.extensions.LayoutContainer

class MovieTabAdapter<A>(
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<MovieTabAdapter<A>.ViewHolder>() {
    private val movies = ArrayList<A>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = movies.size

    fun updateData(newList: List<A>?) {
        if (newList == null) return
        movies.clear()
        movies.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(movies[position])
    }

    inner class ViewHolder(private val view: MovieItemBinding) : RecyclerView.ViewHolder(view.root),
        LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(movie: A) {
            when (movie) {
                is NowPlaying -> {
                    view.titleMovie.text = movie.title
                    view.content.text =
                        if (movie.overview?.length!! > 80) movie.overview.substring(0, 80) + "..."
                        else movie.overview
                    view.releaseDate.text = DateUtils.humanDate(movie.release_date)
                    view.rating.text = movie.vote_average
                    Helpers.loadImage(view.imageView, movie.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(movie.id)
                        }
                    }
                }

                is PopularMovie -> {
                    view.titleMovie.text = movie.title
                    view.content.text =
                        if (movie.overview?.length!! > 80) movie.overview.substring(0, 80) + "..."
                        else movie.overview
                    view.releaseDate.text = DateUtils.humanDate(movie.release_date)
                    view.rating.text = movie.vote_average
                    Helpers.loadImage(view.imageView, movie.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(movie.id)
                        }
                    }
                }

                is Upcoming -> {
                    view.titleMovie.text = movie.title
                    view.content.text =
                        if (movie.overview?.length!! > 80) movie.overview.substring(0, 80) + "..."
                        else movie.overview
                    view.releaseDate.text = DateUtils.humanDate(movie.release_date)
                    view.rating.text = movie.vote_average
                    Helpers.loadImage(view.imageView, movie.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(movie.id)
                        }
                    }
                }
            }
        }
    }
}