package com.codekinian.themovieapps.view.main.tab.movie.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result

interface MovieDataSource {
    fun getNowPlaying(): LiveData<Result<PagedList<NowPlaying>>>
    fun getPopular(): LiveData<Result<PagedList<PopularMovie>>>
    fun getUpcoming(): LiveData<Result<PagedList<Upcoming>>>
    fun getDetailMovie(category: String, movieId: Int): LiveData<Result<Movie>>
    fun getFavoriteMovieById(movieId: Int): LiveData<Movie>
    fun setFavoriteMovie(movie: Movie, isFavorite: Boolean)
}