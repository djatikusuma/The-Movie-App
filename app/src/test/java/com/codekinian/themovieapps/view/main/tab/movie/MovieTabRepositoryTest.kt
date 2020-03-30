package com.codekinian.themovieapps.view.main.tab.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheMovieDao
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.utils.LiveDataTestUtil
import com.codekinian.themovieapps.utils.PagedListUtil
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieTabRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val theMovieDao = mock(TheMovieDao::class.java)
    private val remote = mock(MovieRemoteDataSource::class.java)
    private val scope = CoroutineScope(Dispatchers.IO)
    private val repository = FakeMovieTabRepository(theMovieDao, remote, scope)
    private val nowPlaying = DataDummy.generateDummyNowPlaying()
    private val popularMovie = DataDummy.generateDummyPopularMovie()
    private val upcoming = DataDummy.generateDummyUpcoming()

    @Test
    fun getNowPlaying() {
        scope.launch {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, NowPlaying>
            `when`(theMovieDao.getNowPlaying()).thenReturn(dataSourceFactory)

            val movies = LiveDataTestUtil.getValue(repository.getNowPlaying())
            verify(remote).getNowPlaying(1)
            assertNotNull(movies)

            val movie =
                Result.success(PagedListUtil.mockPagedList(DataDummy.generateDummyNowPlaying()))
            verify(theMovieDao).getNowPlaying()
            assertNotNull(movie.data)
            assertEquals(nowPlaying.size.toLong(), movie.data?.size?.toLong())
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, PopularMovie>
            `when`(theMovieDao.getPopularMovie()).thenReturn(dataSourceFactory)

            val movies = LiveDataTestUtil.getValue(repository.getPopular())
            verify(remote).getPopular(1)
            assertNotNull(movies)

            val movie =
                Result.success(PagedListUtil.mockPagedList(DataDummy.generateDummyPopularMovie()))
            verify(theMovieDao).getPopularMovie()
            assertNotNull(movie.data)
            assertEquals(popularMovie.size.toLong(), movie.data?.size?.toLong())
        }
    }

    @Test
    fun getUpcoming() {
        scope.launch {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Upcoming>
            `when`(theMovieDao.getUpcoming()).thenReturn(dataSourceFactory)

            val movies = LiveDataTestUtil.getValue(repository.getUpcoming())
            verify(remote).getUpcoming(1)
            assertNotNull(movies)

            val movie =
                Result.success(PagedListUtil.mockPagedList(DataDummy.generateDummyUpcoming()))
            verify(theMovieDao).getUpcoming()
            assertNotNull(movie.data)
            assertEquals(upcoming.size.toLong(), movie.data?.size?.toLong())
        }
    }

    @Test
    fun getDetailTv() {
        scope.launch {
            val movieId = nowPlaying[0].id
            `when`(remote.getDetailMovie(movieId)).thenReturn(any())
            val movie = LiveDataTestUtil.getValue(repository.getDetailMovie("now_playing", movieId))
            verify(remote).getDetailMovie(movieId)
            assertNotNull(movie)
            assertEquals(nowPlaying[0].title, movie.data?.title)
        }
    }
}