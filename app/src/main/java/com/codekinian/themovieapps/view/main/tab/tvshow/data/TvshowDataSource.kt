package com.codekinian.themovieapps.view.main.tab.tvshow.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result

interface TvshowDataSource {
    fun getAiringToday(): LiveData<Result<PagedList<AiringToday>>>
    fun getOnTheAir(): LiveData<Result<PagedList<OnTheAir>>>
    fun getPopular(): LiveData<Result<PagedList<PopularTv>>>
    fun getDetailTv(category: String, tvId: Int): LiveData<Result<Tvshow>>
    fun getFavoriteTvById(tvId: Int): LiveData<Tvshow>
    fun setFavoriteTv(tvshow: Tvshow, isFavorite: Boolean)
}