package com.codekinian.themovieapps.view.main.tab.movie.data

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result

interface MovieDataSource {
    fun getNowPlaying(): LiveData<Result<List<NowPlaying>>>
    fun getPopular(): LiveData<Result<List<PopularMovie>>>
    fun getUpcoming(): LiveData<Result<List<Upcoming>>>
    fun getDetailMovie(category: String, movieId: Int): LiveData<Result<Movie>>
    fun getFavoriteMovieById(movieId: Int): LiveData<Movie>
    fun setFavoriteMovie(movie: Movie, isFavorite: Boolean)
}