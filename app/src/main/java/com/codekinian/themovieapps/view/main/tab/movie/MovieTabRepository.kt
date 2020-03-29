package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.response.Result.Status
import com.codekinian.themovieapps.model.room.TheMovieDao
import com.codekinian.themovieapps.utils.liveDataResult
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieDataSource
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MovieTabRepository private constructor(
    private val theMovieDao: TheMovieDao,
    private val remoteData: MovieRemoteDataSource,
    private val scope: CoroutineScope
) : MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieTabRepository? = null

        fun getInstance(
            theMovieDao: TheMovieDao,
            remoteData: MovieRemoteDataSource,
            scope: CoroutineScope
        ): MovieTabRepository =
            instance ?: synchronized(this) {
                instance ?: MovieTabRepository(theMovieDao, remoteData, scope)
            }
    }

    override fun getNowPlaying(): LiveData<Result<List<NowPlaying>>> = liveDataResult(
        databaseQuery = { theMovieDao.getNowPlaying() },
        networkCall = { remoteData.getNowPlaying() },
        saveCallResult = { theMovieDao.insertNowPlaying(it.results) }
    )

    override fun getPopular(): LiveData<Result<List<PopularMovie>>> = liveDataResult(
        databaseQuery = { theMovieDao.getPopularMovie() },
        networkCall = { remoteData.getPopular() },
        saveCallResult = { theMovieDao.insertPopularMovie(it.results) }
    )

    override fun getUpcoming(): LiveData<Result<List<Upcoming>>> = liveDataResult(
        databaseQuery = { theMovieDao.getUpcoming() },
        networkCall = { remoteData.getUpcoming() },
        saveCallResult = { theMovieDao.insertUpcoming(it.results) }
    )

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