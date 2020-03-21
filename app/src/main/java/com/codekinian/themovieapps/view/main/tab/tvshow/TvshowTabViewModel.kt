package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Tvshow

class TvshowTabViewModel(repository: TvshowTabRepository) : ViewModel() {
    val airingToday: LiveData<Tvshow.TvResult> = repository.getAiringToday()
    val onTheAir: LiveData<Tvshow.TvResult> = repository.getOnTheAir()
    val popularTv: LiveData<Tvshow.TvResult> = repository.getPopular()
}
