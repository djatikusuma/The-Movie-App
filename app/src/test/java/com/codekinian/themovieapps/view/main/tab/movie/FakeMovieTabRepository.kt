package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.response.Result.Status
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieDataSource
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class FakeMovieTabRepository(
    private val remoteData: MovieRemoteDataSource,
    private val scope: CoroutineScope
) : MovieDataSource {

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

    override fun getPopular(): LiveData<Movie.MovieResult> {
        val movieResult = MutableLiveData<Movie.MovieResult>()
        scope.launch {
            val response = remoteData.getPopular()
            if (response.status == Status.SUCCESS) {
                response.data?.let {
                    movieResult.postValue(it)
                }
            }
        }

        return movieResult
    }

    override fun getUpcoming(): LiveData<Movie.MovieResult> {
        val movieResult = MutableLiveData<Movie.MovieResult>()
        scope.launch {
            val response = remoteData.getUpcoming()
            if (response.status == Status.SUCCESS) {
                response.data?.let {
                    movieResult.postValue(it)
                }
            }
        }

        return movieResult
    }

    override fun getDetailMovie(movieId: Int): LiveData<Movie> {
        val movieResult = MutableLiveData<Movie>()
        scope.launch {
            val response = remoteData.getDetailMovie(movieId)
            if (response.status == Status.SUCCESS) {
                response.data?.let {
                    movieResult.postValue(it)
                }
            }
        }

        return movieResult
    }


}