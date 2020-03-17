package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.Movie
import com.codekinian.themovieapps.utils.DataDummy

class MovieTabViewModel : ViewModel() {
    // Get All Movies Data
    val movies: List<Movie> = DataDummy.generateDummyMovies()
}
