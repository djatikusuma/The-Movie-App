package com.codekinian.themovieapps.view.detail.movie

import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.Movie
import com.codekinian.themovieapps.utils.DataDummy

class DetailMovieViewModel : ViewModel() {
    fun getDetailMovie(id: Int): Movie? = DataDummy.getMovieById(id)
}