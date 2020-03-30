package com.codekinian.themovieapps.view.main.tab.tvshow.data

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result

interface TvshowDataSource {
    fun getAiringToday(): LiveData<Result<List<AiringToday>>>
    fun getOnTheAir(): LiveData<Result<List<OnTheAir>>>
    fun getPopular(): LiveData<Result<List<PopularTv>>>
    fun getDetailTv(category: String, tvId: Int): LiveData<Result<Tvshow>>
    fun getFavoriteTvById(tvId: Int): LiveData<Tvshow>
    fun setFavoriteTv(tvshow: Tvshow, isFavorite: Boolean)
}