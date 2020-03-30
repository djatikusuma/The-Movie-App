package com.codekinian.themovieapps.view.main.tab.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
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
    private lateinit var observerNowPlaying: Observer<Result<List<NowPlaying>>>

    @Mock
    private lateinit var observerPopular: Observer<Result<List<PopularMovie>>>

    @Mock
    private lateinit var observerUpcoming: Observer<Result<List<Upcoming>>>

    @Before
    fun setUp() {
        viewModel = MovieTabViewModel(repository)
    }

    @Test
    fun getNowPlaying() {
        scope.launch {
            val dummyMovies = Result.success(DataDummy.generateDummyNowPlaying())
            val movies = MutableLiveData<Result<List<NowPlaying>>>()
            movies.value = dummyMovies

            val moviesData = viewModel.nowPlaying.value
            verify(repository).getNowPlaying()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.data?.size)

            viewModel.nowPlaying.observeForever(observerNowPlaying)
            verify(observerNowPlaying).onChanged(dummyMovies)
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            val dummyMovies = Result.success(DataDummy.generateDummyPopularMovie())
            val movies = MutableLiveData<Result<List<PopularMovie>>>()
            movies.value = dummyMovies

            val moviesData = viewModel.popular.value
            verify(repository).getPopular()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.data?.size)

            viewModel.popular.observeForever(observerPopular)
            verify(observerPopular).onChanged(dummyMovies)
        }
    }

    @Test
    fun getUpcoming() {
        scope.launch {
            val dummyMovies = Result.success(DataDummy.generateDummyUpcoming())
            val movies = MutableLiveData<Result<List<Upcoming>>>()
            movies.value = dummyMovies

            val moviesData = viewModel.upcoming.value
            verify(repository).getUpcoming()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.data?.size)

            viewModel.upcoming.observeForever(observerUpcoming)
            verify(observerUpcoming).onChanged(dummyMovies)
        }
    }
}