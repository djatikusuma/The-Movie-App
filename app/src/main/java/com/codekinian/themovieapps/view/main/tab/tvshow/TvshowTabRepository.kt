package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowDataSource
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class TvshowTabRepository private constructor(
    private val remoteData: TvshowRemoteDataSource,
    private val scope: CoroutineScope
) : TvshowDataSource {

    companion object {
        @Volatile
        private var instance: TvshowTabRepository? = null

        fun getInstance(
            remoteData: TvshowRemoteDataSource,
            scope: CoroutineScope
        ): TvshowTabRepository =
            instance ?: synchronized(this) {
                instance ?: TvshowTabRepository(remoteData, scope)
            }
    }

    override fun getAiringToday(): LiveData<Tvshow.TvResult> {
        val tvResult = MutableLiveData<Tvshow.TvResult>()
        scope.launch {
            val response = remoteData.getAiringToday()
            if (response.status == Result.Status.SUCCESS) {
                response.data?.let {
                    tvResult.postValue(it)
                }
            }
        }

        return tvResult
    }

    override fun getOnTheAir(): LiveData<Tvshow.TvResult> {
        val tvResult = MutableLiveData<Tvshow.TvResult>()
        scope.launch {
            val response = remoteData.getOnTheAir()
            if (response.status == Result.Status.SUCCESS) {
                response.data?.let {
                    tvResult.postValue(it)
                }
            }
        }

        return tvResult
    }

    override fun getPopular(): LiveData<Tvshow.TvResult> {
        val tvResult = MutableLiveData<Tvshow.TvResult>()
        scope.launch {
            val response = remoteData.getPopular()
            if (response.status == Result.Status.SUCCESS) {
                response.data?.let {
                    tvResult.postValue(it)
                }
            }
        }

        return tvResult
    }

    override fun getDetailTv(tvId: Int): LiveData<Tvshow> {
        val tvResult = MutableLiveData<Tvshow>()
        scope.launch {
            val response = remoteData.getDetailTv(tvId)
            if (response.status == Result.Status.SUCCESS) {
                response.data?.let {
                    tvResult.postValue(it)
                }
            }
        }

        return tvResult
    }


}