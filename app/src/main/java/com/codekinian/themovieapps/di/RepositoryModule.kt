package com.codekinian.themovieapps.di

import com.codekinian.themovieapps.view.main.tab.favorite.FavoriteTabRepository
import com.codekinian.themovieapps.view.main.tab.favorite.data.FavoriteDataSource
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabRepository
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieDataSource
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowDataSource
import org.koin.dsl.module

val repositoryModule = module {
    factory<FavoriteDataSource> { FavoriteTabRepository(get()) }
    factory<MovieDataSource> { MovieTabRepository(get(), get()) }
    factory<TvshowDataSource> { TvshowTabRepository(get(), get()) }
}