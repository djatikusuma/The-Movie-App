package com.codekinian.themovieapps.view.main.tab.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.view.main.tab.favorite.data.FavoriteDataSource
import kotlinx.coroutines.Dispatchers

class FavoriteTabRepository private constructor(
    private val theMovieDatabase: TheMovieDatabase
) : FavoriteDataSource {

    companion object {
        @Volatile
        private var instance: FavoriteTabRepository? = null

        fun getInstance(
            theMovieDatabase: TheMovieDatabase
        ): FavoriteTabRepository =
            instance ?: synchronized(this) {
                instance ?: FavoriteTabRepository(theMovieDatabase)
            }
    }

    private val theMovieDao by lazy {
        theMovieDatabase.theMovieDao()
    }

    private val theTvDao by lazy {
        theMovieDatabase.theTvDao()
    }

    override fun getFavoriteMovies(): LiveData<Result<List<Movie>>> = liveData(Dispatchers.IO) {
        emit(Result.loading())
        val source = theMovieDao.getMovies().map { Result.success(it) }
        emitSource(source)
    }

    override fun getFavoriteTvShows(): LiveData<Result<List<Tvshow>>> = liveData(Dispatchers.IO) {
        emit(Result.loading())
        val source = theTvDao.getTvShows().map { Result.success(it) }
        emitSource(source)
    }
}