package com.codekinian.themovieapps.di

import com.codekinian.themovieapps.model.room.TheMovieDao
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.model.room.TheTvDao
import com.codekinian.themovieapps.view.main.tab.favorite.FavoriteTabRepository
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabRepository
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
import org.koin.dsl.module

val repositoryModule = module {
    fun provideFavoriteTabRepository(dao: TheMovieDatabase): FavoriteTabRepository {
        return FavoriteTabRepository(dao)
    }

    fun provideMovieTabRepository(
        dao: TheMovieDao,
        remote: MovieRemoteDataSource
    ): MovieTabRepository {
        return MovieTabRepository(dao, remote)
    }

    fun provideTvshowTabRepository(
        dao: TheTvDao,
        remote: TvshowRemoteDataSource
    ): TvshowTabRepository {
        return TvshowTabRepository(dao, remote)
    }

    single { provideFavoriteTabRepository(get()) }
    single { provideMovieTabRepository(get(), get()) }
    single { provideTvshowTabRepository(get(), get()) }
}