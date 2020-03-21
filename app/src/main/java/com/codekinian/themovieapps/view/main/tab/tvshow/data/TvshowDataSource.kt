package com.codekinian.themovieapps.view.main.tab.tvshow.data

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Tvshow

interface TvshowDataSource {
    fun getAiringToday(): LiveData<Tvshow.TvResult>
    fun getOnTheAir(): LiveData<Tvshow.TvResult>
    fun getPopular(): LiveData<Tvshow.TvResult>
    fun getDetailTv(tvId: Int): LiveData<Tvshow>
}