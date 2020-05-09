package com.codekinian.themovieapps.view.main.tab.favorite.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result

interface FavoriteDataSource {
    fun getFavoriteMovies(): LiveData<Result<PagedList<Movie>>>
    fun getFavoriteTvShows(): LiveData<Result<PagedList<Tvshow>>>
}