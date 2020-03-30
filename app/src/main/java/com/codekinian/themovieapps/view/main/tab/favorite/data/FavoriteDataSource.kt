package com.codekinian.themovieapps.view.main.tab.favorite.data

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result

interface FavoriteDataSource {
    fun getFavoriteMovies(): LiveData<Result<List<Movie>>>
    fun getFavoriteTvShows(): LiveData<Result<List<Tvshow>>>
}