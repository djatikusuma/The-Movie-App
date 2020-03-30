package com.codekinian.themovieapps.view.main.tab.movie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.themovieapps.databinding.MovieItemBinding
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.utils.DateUtils
import com.codekinian.themovieapps.utils.Helpers
import kotlinx.android.extensions.LayoutContainer

class MovieTabAdapter<A>(
    private val onClick: (Int) -> Unit
) : PagedListAdapter<A, MovieTabAdapter<A>.ViewHolder>(MovieCallBack<A>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movies = getItem(position)
        movies?.let {
            holder.bindItem(it)
        }
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

                is Movie -> {
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

private class MovieCallBack<A> : DiffUtil.ItemCallback<A>() {

    override fun areItemsTheSame(oldItem: A, newItem: A): Boolean {
        return if ((oldItem is NowPlaying) && (newItem is NowPlaying)) {
            oldItem.title == newItem.title
        } else if ((oldItem is PopularMovie) && (newItem is PopularMovie)) {
            oldItem.title == newItem.title
        } else if ((oldItem is Upcoming) && (newItem is Upcoming)) {
            oldItem.title == newItem.title
        } else {
            (oldItem as Movie).title == (newItem as Movie).title
        }
    }

    override fun areContentsTheSame(oldItem: A, newItem: A): Boolean {
        return if ((oldItem is NowPlaying) && (newItem is NowPlaying)) {
            (oldItem as NowPlaying) == (newItem as NowPlaying)
        } else if ((oldItem is PopularMovie) && (newItem is PopularMovie)) {
            (oldItem as PopularMovie) == (newItem as PopularMovie)
        } else if ((oldItem is Upcoming) && (newItem is Upcoming)) {
            (oldItem as Upcoming) == (newItem as Upcoming)
        } else {
            (oldItem as Movie) == (newItem as Movie)
        }
    }
}