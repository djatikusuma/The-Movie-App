package com.codekinian.themovieapps.view.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository

class DetailTvshowViewModel(private val repository: TvshowTabRepository) : ViewModel() {
    fun detailTv(tvId: Int): LiveData<Tvshow> = repository.getDetailTv(tvId)
}