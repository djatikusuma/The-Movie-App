package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheTvDao
import com.codekinian.themovieapps.utils.liveDataResult
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowDataSource
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource

class TvshowTabRepository private constructor(
    private val theTvDao: TheTvDao,
    private val remoteData: TvshowRemoteDataSource
) : TvshowDataSource {

    companion object {
        @Volatile
        private var instance: TvshowTabRepository? = null

        fun getInstance(
            theTvDao: TheTvDao,
            remoteData: TvshowRemoteDataSource
        ): TvshowTabRepository =
            instance ?: synchronized(this) {
                instance ?: TvshowTabRepository(theTvDao, remoteData)
            }
    }

    override fun getAiringToday(): LiveData<Result<List<AiringToday>>> = liveDataResult(
        databaseQuery = { theTvDao.getAiringToday() },
        networkCall = { remoteData.getAiringToday() },
        saveCallResult = { theTvDao.insertAiringToday(it.results) }
    )

    override fun getOnTheAir(): LiveData<Result<List<OnTheAir>>> = liveDataResult(
        databaseQuery = { theTvDao.getOnTheAir() },
        networkCall = { remoteData.getOnTheAir() },
        saveCallResult = { theTvDao.insertOnTheAir(it.results) }
    )

    override fun getPopular(): LiveData<Result<List<PopularTv>>> = liveDataResult(
        databaseQuery = { theTvDao.getPopularTv() },
        networkCall = { remoteData.getPopular() },
        saveCallResult = { theTvDao.insertPopular(it.results) }
    )

    override fun getDetailTv(category: String, tvId: Int): LiveData<Result<Tvshow>> =
        liveDataResult(
            databaseQuery = {
                when (category) {
                    "airing_today" -> theTvDao.getAiringTodayById(tvId)
                    "popular" -> theTvDao.getPopularTvById(tvId)
                    else -> theTvDao.getOnTheAirById(tvId)
                }
            },
            networkCall = { remoteData.getDetailTv(tvId) },
            saveCallResult = { theTvDao.insertTvShow(it) }
        )


}