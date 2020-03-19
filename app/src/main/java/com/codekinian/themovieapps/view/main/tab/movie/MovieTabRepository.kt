package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.response.Result.Status
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieDataSource
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieTabRepository private constructor(
    private val remoteData: MovieRemoteDataSource,
    private val scope: CoroutineScope
) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieTabRepository? = null

        fun getInstance(
            remoteData: MovieRemoteDataSource,
            scope: CoroutineScope
        ): MovieTabRepository =
            instance ?: synchronized(this) {
                instance ?: MovieTabRepository(remoteData, scope)
            }
    }

    override fun getNowPlaying(): LiveData<Movie.MovieResult> {
        val movieResult = MutableLiveData<Movie.MovieResult>()
        scope.launch {
            val response = remoteData.getNowPlaying()
            if (response.status == Status.SUCCESS) {
                response.data?.let {
                    movieResult.postValue(it)
                }
            }
        }

        return movieResult
    }


}