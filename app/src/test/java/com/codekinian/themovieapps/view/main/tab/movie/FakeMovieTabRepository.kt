package com.codekinian.themovieapps.view.main.tab.movie

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
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

class FakeMovieTabRepository constructor(
    private val theMovieDao: TheMovieDao,
    private val remoteData: MovieRemoteDataSource,
    private val scope: CoroutineScope
) : MovieDataSource {

    override fun getNowPlaying(): LiveData<Result<PagedList<NowPlaying>>> = liveDataResult(
        databaseQuery = {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            LivePagedListBuilder(theMovieDao.getNowPlaying(), config).build()
        },
        networkCall = { remoteData.getNowPlaying(1) },
        saveCallResult = { theMovieDao.insertNowPlaying(it.results) }
    )

    override fun getPopular(): LiveData<Result<PagedList<PopularMovie>>> = liveDataResult(
        databaseQuery = {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            LivePagedListBuilder(theMovieDao.getPopularMovie(), config).build()
        },
        networkCall = { remoteData.getPopular(1) },
        saveCallResult = { theMovieDao.insertPopularMovie(it.results) }
    )

    override fun getUpcoming(): LiveData<Result<PagedList<Upcoming>>> = liveDataResult(
        databaseQuery = {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            LivePagedListBuilder(theMovieDao.getUpcoming(), config).build()
        },
        networkCall = { remoteData.getUpcoming(1) },
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