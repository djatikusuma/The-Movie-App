package com.codekinian.themovieapps.view.main.tab.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieTabViewModelTest {

    private lateinit var viewModel: MovieTabViewModel
    private val scope = CoroutineScope(Dispatchers.IO)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieTabRepository

    @Mock
    private lateinit var observer: Observer<Movie.MovieResult>

    @Before
    fun setUp() {
        viewModel = MovieTabViewModel(repository)
    }

    @Test
    fun getNowPlaying() {
        scope.launch {
            val dummyMovies = DataDummy.generateDummyMovies()
            val movies = MutableLiveData<Movie.MovieResult>()
            movies.value = dummyMovies

            `when`(repository.getNowPlaying()).thenReturn(movies)
            val moviesData = viewModel.nowPlaying.value
            verify(repository).getNowPlaying()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.results?.size)

            viewModel.nowPlaying.observeForever(observer)
            verify(observer).onChanged(dummyMovies)
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            val dummyMovies = DataDummy.generateDummyMovies()
            val movies = MutableLiveData<Movie.MovieResult>()
            movies.value = dummyMovies

            `when`(repository.getPopular()).thenReturn(movies)
            val moviesData = viewModel.popular.value
            verify(repository).getPopular()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.results?.size)

            viewModel.popular.observeForever(observer)
            verify(observer).onChanged(dummyMovies)
        }
    }

    @Test
    fun getUpcoming() {
        scope.launch {
            val dummyMovies = DataDummy.generateDummyMovies()
            val movies = MutableLiveData<Movie.MovieResult>()
            movies.value = dummyMovies

            `when`(repository.getUpcoming()).thenReturn(movies)
            val moviesData = viewModel.upcoming.value
            verify(repository).getUpcoming()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.results?.size)

            viewModel.upcoming.observeForever(observer)
            verify(observer).onChanged(dummyMovies)
        }
    }
}