package com.codekinian.themovieapps.view.main.tab.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result

class FavoriteTabViewModel(repository: FavoriteTabRepository) : ViewModel() {
    val movies: LiveData<Result<PagedList<Movie>>> = repository.getFavoriteMovies()
    val tvshows: LiveData<Result<PagedList<Tvshow>>> = repository.getFavoriteTvShows()
}
