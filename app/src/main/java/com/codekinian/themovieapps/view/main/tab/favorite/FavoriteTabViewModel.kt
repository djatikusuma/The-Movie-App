package com.codekinian.themovieapps.view.main.tab.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result

class FavoriteTabViewModel(repository: FavoriteTabRepository) : ViewModel() {
    val movies: LiveData<Result<List<Movie>>> = repository.getFavoriteMovies()
    val tvshows: LiveData<Result<List<Tvshow>>> = repository.getFavoriteTvShows()
}
