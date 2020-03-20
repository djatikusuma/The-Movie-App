package com.codekinian.themovieapps.view.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabRepository

class DetailMovieViewModel(private val repository: MovieTabRepository) : ViewModel() {
    fun detailMovie(movieId: Int): LiveData<Movie> = repository.getDetailMovie(movieId)
}