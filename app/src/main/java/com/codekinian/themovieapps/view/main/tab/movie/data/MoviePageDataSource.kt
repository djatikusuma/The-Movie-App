package com.codekinian.themovieapps.view.main.tab.movie.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MoviePageDataSource(
    private val category: String,
    private val dataSource: MovieRemoteDataSource,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Any>() {
    private val progressLiveStatus = MutableLiveData<Boolean>()

    fun getProgressLiveStatus(): LiveData<Boolean> = progressLiveStatus

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Any>
    ) {
        progressLiveStatus.postValue(true)
        when (category) {
            "now_playing" -> fetchNowPlaying(1) {
                progressLiveStatus.postValue(false)
                callback.onResult(it, null, 2)
            }
            "popular" -> fetchPopular(1) {
                progressLiveStatus.postValue(false)
                callback.onResult(it, null, 2)
            }
            "upcoming" -> fetchUpcoming(1) {
                progressLiveStatus.postValue(false)
                callback.onResult(it, null, 2)
            }
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Any>) {
        val page = params.key
        when (category) {
            "now_playing" -> fetchNowPlaying(page) {
                callback.onResult(it, page + 1)
            }
            "popular" -> fetchPopular(page) {
                callback.onResult(it, page + 1)
            }
            "upcoming" -> fetchUpcoming(page) {
                callback.onResult(it, page + 1)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Any>) {
        val page = params.key
        when (category) {
            "now_playing" -> fetchNowPlaying(page) {
                callback.onResult(it, page - 1)
            }
            "popular" -> fetchPopular(page) {
                callback.onResult(it, page - 1)
            }
            "upcoming" -> fetchUpcoming(page) {
                callback.onResult(it, page - 1)
            }
        }
    }

    override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }

    private fun fetchNowPlaying(page: Int, callback: (List<NowPlaying>) -> Unit) {
        scope.launch(getJobErrorHandler()) {
            val response = dataSource.getNowPlaying(page)

            if (response.status == Result.Status.SUCCESS) {
                val res = response.data
                if (res != null) {
                    callback(res.results)
                }
            } else if (response.status == Result.Status.ERROR) {
                postError(response.message!!)
            }
        }
    }

    private fun fetchPopular(page: Int, callback: (List<PopularMovie>) -> Unit) {
        scope.launch(getJobErrorHandler()) {
            val response = dataSource.getPopular(page)

            if (response.status == Result.Status.SUCCESS) {
                val res = response.data
                if (res != null) {
                    callback(res.results)
                }
            } else if (response.status == Result.Status.ERROR) {
                postError(response.message!!)
            }
        }
    }

    private fun fetchUpcoming(page: Int, callback: (List<Upcoming>) -> Unit) {
        scope.launch(getJobErrorHandler()) {
            val response = dataSource.getUpcoming(page)

            if (response.status == Result.Status.SUCCESS) {
                val res = response.data
                if (res != null) {
                    callback(res.results)
                }
            } else if (response.status == Result.Status.ERROR) {
                postError(response.message!!)
            }
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        postError(e.message ?: e.toString())
    }

    private fun postError(message: String) {
        Log.e("error", "An error happened: $message")
    }

}