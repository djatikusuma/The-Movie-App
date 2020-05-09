package com.codekinian.themovieapps.di

import android.content.Context
import androidx.room.Room
import com.codekinian.themovieapps.BuildConfig
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.network.ApiRoute
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { Gson() }
    single { httpLoggingInterceptor() }
    single { okHttpClient(get(), get()) }
    single { retrofit(get(), get(), get()) }
    single { restApi(get()) }
    single {
        Room.databaseBuilder(
            androidApplication(),
            TheMovieDatabase::class.java,
            "AppMovieDatabaseTwo.db"
        )
    }
    single { get<TheMovieDatabase>().theMovieDao() }
    single { get<TheMovieDatabase>().theTvDao() }
    single { MovieRemoteDataSource(get()) }
    single { TvshowRemoteDataSource(get()) }
}

private fun httpLoggingInterceptor(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

private fun okHttpClient(
    context: Context,
    loggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    val okHttpBuilder = OkHttpClient.Builder()
        .connectTimeout(10000, TimeUnit.MILLISECONDS)
    if (BuildConfig.DEBUG) okHttpBuilder.addInterceptor(loggingInterceptor)
    return okHttpBuilder.build()
}

private fun retrofit(
    context: Context,
    gson: Gson,
    httpClient: OkHttpClient
): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.ENDPOINT_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(httpClient)
        .build()
}

private fun restApi(retrofit: Retrofit): ApiRoute = retrofit.create(ApiRoute::class.java)