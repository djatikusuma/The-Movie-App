package com.codekinian.themovieapps.network

import com.codekinian.themovieapps.BuildConfig
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRoute {
    // Movie Route
    @GET("movie/now_playing")
    suspend fun nowPlayingMovie(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<NowPlaying.Result>

    @GET("movie/popular")
    suspend fun popularMovie(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<PopularMovie.Result>

    @GET("movie/upcoming")
    suspend fun upcomingMovie(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Upcoming.Result>

    @GET("movie/{movie_id}")
    suspend fun detailMovie(@Path("movie_id") movie_id: Int, @Query("api_key") key: String = BuildConfig.KEY): Response<Movie>

    // TV Show Route
    @GET("tv/airing_today")
    suspend fun airingToday(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Tvshow.TvResult>

    @GET("tv/on_the_air")
    suspend fun onTheAir(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Tvshow.TvResult>

    @GET("tv/popular")
    suspend fun popularTv(@Query("page") page: Int = 1, @Query("api_key") key: String = BuildConfig.KEY): Response<Tvshow.TvResult>

    @GET("tv/{tv_id}")
    suspend fun detailTv(@Path("tv_id") tv_id: Int, @Query("api_key") key: String = BuildConfig.KEY): Response<Tvshow>
}