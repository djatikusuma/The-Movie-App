package com.codekinian.themovieapps.view.main.tab.movie.data

import com.codekinian.themovieapps.network.ApiRoute
import com.codekinian.themovieapps.network.BaseDataSource

class MovieRemoteDataSource(private val service: ApiRoute) : BaseDataSource() {

    companion object {
        @Volatile
        private var instance: MovieRemoteDataSource? = null

        fun getInstance(service: ApiRoute) =
            instance ?: synchronized(this) {
                instance
                    ?: MovieRemoteDataSource(service).also { instance = it }
            }
    }

    suspend fun getNowPlaying(page: Int) = getResult { service.nowPlayingMovie(page) }

    suspend fun getPopular(page: Int) = getResult { service.popularMovie(page) }

    suspend fun getUpcoming(page: Int) = getResult { service.upcomingMovie(page) }

    suspend fun getDetailMovie(movieId: Int) = getResult { service.detailMovie(movieId) }

}