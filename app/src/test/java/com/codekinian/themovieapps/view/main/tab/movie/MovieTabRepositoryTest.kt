package com.codekinian.themovieapps.view.main.tab.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.utils.LiveDataTestUtil
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
import org.mockito.Mockito

class MovieTabRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(MovieRemoteDataSource::class.java)
    private val scope = CoroutineScope(Dispatchers.IO)
    private val repository = FakeMovieTabRepository(remote, scope)
    private val moviesResponse = DataDummy.generateDummyMovies()

    @Test
    fun getNowPlaying() {
        scope.launch {
            Mockito.`when`(remote.getNowPlaying()).thenReturn(any())
            val movies = LiveDataTestUtil.getValue(repository.getNowPlaying())
            verify(remote).getNowPlaying()
            assertNotNull(movies)
            assertEquals(moviesResponse.results.size.toLong(), movies.results.size.toLong())
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            Mockito.`when`(remote.getPopular()).thenReturn(any())
            val movies = LiveDataTestUtil.getValue(repository.getPopular())
            verify(remote).getPopular()
            assertNotNull(movies)
            assertEquals(moviesResponse.results.size.toLong(), movies.results.size.toLong())
        }
    }

    @Test
    fun getUpcoming() {
        scope.launch {
            Mockito.`when`(remote.getUpcoming()).thenReturn(any())
            val movies = LiveDataTestUtil.getValue(repository.getUpcoming())
            verify(remote).getUpcoming()
            assertNotNull(movies)
            assertEquals(moviesResponse.results.size.toLong(), movies.results.size.toLong())
        }
    }
}