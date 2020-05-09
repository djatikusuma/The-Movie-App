package com.codekinian.themovieapps.view.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabRepository

class DetailMovieViewModel(private val repository: MovieTabRepository) : ViewModel() {
    private val movieId = MutableLiveData<Int>()
    val isFavoriteMovie = Transformations.switchMap(movieId) { repository.getFavoriteMovieById(it) }

    fun setMovieId(movieId: Int) {
        this.movieId.value = movieId
    }

    fun detailMovie(category: String, movieId: Int): LiveData<Result<Movie>> =
        repository.getDetailMovie(category, movieId)

    fun setFavoriteMovie() {
        isFavoriteMovie.value?.let {
            val favoriteState = !it.isFavorite
            repository.setFavoriteMovie(it, favoriteState)
        }
    }
}