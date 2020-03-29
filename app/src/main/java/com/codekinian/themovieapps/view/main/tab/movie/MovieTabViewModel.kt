package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result

class MovieTabViewModel(repository: MovieTabRepository) : ViewModel() {
    val nowPlaying: LiveData<Result<List<NowPlaying>>> = repository.getNowPlaying()
    val popular: LiveData<Result<List<PopularMovie>>> = repository.getPopular()
    val upcoming: LiveData<Result<List<Upcoming>>> = repository.getUpcoming()
}
