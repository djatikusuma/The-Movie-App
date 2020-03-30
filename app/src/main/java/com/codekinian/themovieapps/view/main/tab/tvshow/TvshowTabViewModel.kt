package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result

class TvshowTabViewModel(repository: TvshowTabRepository) : ViewModel() {
    val airingToday: LiveData<Result<PagedList<AiringToday>>> = repository.getAiringToday()
    val onTheAir: LiveData<Result<PagedList<OnTheAir>>> = repository.getOnTheAir()
    val popularTv: LiveData<Result<PagedList<PopularTv>>> = repository.getPopular()
}
