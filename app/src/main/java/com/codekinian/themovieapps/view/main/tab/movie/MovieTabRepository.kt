package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result
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

    override fun getDetailMovie(category: String, movieId: Int): LiveData<Result<Movie>> =
        liveDataResult(
            databaseQuery = {
                when (category) {
                    "now_playing" -> theMovieDao.getNowPlayingById(movieId)
                    "upcoming" -> theMovieDao.getUpcomingById(movieId)
                    "popular" -> theMovieDao.getPopularMovieById(movieId)
                    else -> theMovieDao.getMovieById(movieId)
                }
            },
            networkCall = { remoteData.getDetailMovie(movieId) },
            saveCallResult = { theMovieDao.insertDetailMovie(it) }
        )

    override fun getFavoriteMovieById(movieId: Int): LiveData<Movie> =
        theMovieDao.getMovieById(movieId)

    override fun setFavoriteMovie(movie: Movie, isFavorite: Boolean) {
        scope.launch {
            movie.isFavorite = isFavorite
            theMovieDao.updateMovie(movie)
        }
    }
}