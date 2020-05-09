package com.codekinian.themovieapps.view.main.tab.tvshow.data

import com.codekinian.themovieapps.network.ApiRoute
import com.codekinian.themovieapps.network.BaseDataSource

class TvshowRemoteDataSource(private val service: ApiRoute) : BaseDataSource() {

    /*companion object {
        @Volatile
        private var instance: TvshowRemoteDataSource? = null

        fun getInstance(service: ApiRoute) =
            instance ?: synchronized(this) {
                instance
                    ?: TvshowRemoteDataSource(service).also { instance = it }
            }
    }*/

    suspend fun getAiringToday() = getResult { service.airingToday() }

    suspend fun getOnTheAir() = getResult { service.onTheAir() }

    suspend fun getPopular() = getResult { service.popularTv() }

    suspend fun getDetailTv(tvId: Int) = getResult { service.detailTv(tvId) }

}