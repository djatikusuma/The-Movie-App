package com.codekinian.themovieapps.network

import com.codekinian.themovieapps.BuildConfig
import com.codekinian.themovieapps.model.data.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRoute {
    // Movie Route
    @GET("movie/now_playing")
    suspend fun nowPlayingMovie(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Movie.MovieResult>

    @GET("movie/popular")
    suspend fun popularMovie(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Movie.MovieResult>

    @GET("movie/upcoming")
    suspend fun upcomingMovie(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Movie.MovieResult>

    @GET("movie/{movie_id}")
    suspend fun detailMovie(@Path("movie_id") movie_id: Int, @Query("api_key") key: String = BuildConfig.KEY): Response<Movie>
}