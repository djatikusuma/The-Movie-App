package com.codekinian.themovieapps.view.main.tab.movie.data

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Movie

interface MovieDataSource {
    fun getNowPlaying(): LiveData<Movie.MovieResult>
}