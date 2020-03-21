package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Movie

class MovieTabViewModel(repository: MovieTabRepository) : ViewModel() {
    val nowPlaying: LiveData<Movie.MovieResult> = repository.getNowPlaying()
    val popular: LiveData<Movie.MovieResult> = repository.getPopular()
    val upcoming: LiveData<Movie.MovieResult> = repository.getUpcoming()
}
