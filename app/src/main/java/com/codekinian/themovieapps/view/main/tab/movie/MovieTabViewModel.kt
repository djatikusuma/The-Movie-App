package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result

class MovieTabViewModel(repository: MovieTabRepository) : ViewModel() {
    val nowPlaying: LiveData<Result<PagedList<NowPlaying>>> = repository.getNowPlaying()
    val popular: LiveData<Result<PagedList<PopularMovie>>> = repository.getPopular()
    val upcoming: LiveData<Result<PagedList<Upcoming>>> = repository.getUpcoming()
}
