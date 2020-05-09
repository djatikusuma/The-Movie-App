package com.codekinian.themovieapps.view.main.tab.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.utils.EspressoIdlingResource
import com.codekinian.themovieapps.view.main.tab.favorite.data.FavoriteDataSource
import kotlinx.coroutines.Dispatchers

class FavoriteTabRepository(
    private val theMovieDatabase: TheMovieDatabase
) : FavoriteDataSource {

    /*companion object {
        @Volatile
        private var instance: FavoriteTabRepository? = null

        fun getInstance(
            theMovieDatabase: TheMovieDatabase
        ): FavoriteTabRepository =
            instance ?: synchronized(this) {
                instance ?: FavoriteTabRepository(theMovieDatabase)
            }
    }*/

    private val theMovieDao by lazy {
        theMovieDatabase.theMovieDao()
    }

    private val theTvDao by lazy {
        theMovieDatabase.theTvDao()
    }

    override fun getFavoriteMovies(): LiveData<Result<PagedList<Movie>>> =
        liveData(Dispatchers.IO) {
            EspressoIdlingResource.increment()
            emit(Result.loading())
            val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build()
            val database = LivePagedListBuilder(theMovieDao.getMovies(), config).build()
            val source = database.map {
                EspressoIdlingResource.increment()
                Result.success(it)
            }
            emitSource(source)
    }

    override fun getFavoriteTvShows(): LiveData<Result<PagedList<Tvshow>>> =
        liveData(Dispatchers.IO) {
            EspressoIdlingResource.increment()
            emit(Result.loading())
            val config = PagedList.Config.Builder()
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build()
            val database = LivePagedListBuilder(theTvDao.getTvShows(), config).build()
            val source = database.map {
                EspressoIdlingResource.increment()
                Result.success(it)
            }
            emitSource(source)
    }
}