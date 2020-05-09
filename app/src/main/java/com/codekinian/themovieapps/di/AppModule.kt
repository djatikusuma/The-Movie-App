package com.codekinian.themovieapps.di

import com.codekinian.themovieapps.view.detail.movie.DetailMovieViewModel
import com.codekinian.themovieapps.view.detail.tvshow.DetailTvshowViewModel
import com.codekinian.themovieapps.view.main.tab.favorite.FavoriteTabViewModel
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabViewModel
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { DetailMovieViewModel(get()) }
    viewModel { DetailTvshowViewModel(get()) }
    viewModel { FavoriteTabViewModel(get()) }
    viewModel { MovieTabViewModel(get()) }
    viewModel { TvshowTabViewModel(get()) }
}