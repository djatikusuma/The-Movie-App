package com.codekinian.themovieapps.view.main.tab.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.movies.NowPlaying
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.data.movies.Upcoming
import com.codekinian.themovieapps.model.response.Result
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
import org.mockito.Mockito.lenient
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
    private lateinit var observerNowPlaying: Observer<Result<PagedList<NowPlaying>>>

    @Mock
    private lateinit var pagedListNowPlaying: PagedList<NowPlaying>

    @Mock
    private lateinit var observerPopular: Observer<Result<PagedList<PopularMovie>>>

    @Mock
    private lateinit var pagedListPopular: PagedList<PopularMovie>

    @Mock
    private lateinit var observerUpcoming: Observer<Result<PagedList<Upcoming>>>

    @Mock
    private lateinit var pagedListUpcoming: PagedList<Upcoming>

    @Before
    fun setUp() {
        viewModel = MovieTabViewModel(repository)
    }

    @Test
    fun getNowPlaying() {
        scope.launch {
            val dummyMovies = Result.success(pagedListNowPlaying)
            lenient().`when`(dummyMovies.data?.size).thenReturn(10)
            val movies = MutableLiveData<Result<PagedList<NowPlaying>>>()
            movies.value = dummyMovies

            lenient().`when`(repository.getNowPlaying()).thenReturn(movies)
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
            val dummyMovies = Result.success(pagedListPopular)
            lenient().`when`(dummyMovies.data?.size).thenReturn(10)
            val movies = MutableLiveData<Result<PagedList<PopularMovie>>>()
            movies.value = dummyMovies

            lenient().`when`(repository.getPopular()).thenReturn(movies)
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
            val dummyMovies = Result.success(pagedListUpcoming)
            lenient().`when`(dummyMovies.data?.size).thenReturn(10)
            val movies = MutableLiveData<Result<PagedList<Upcoming>>>()
            movies.value = dummyMovies

            lenient().`when`(repository.getUpcoming()).thenReturn(movies)
            val moviesData = viewModel.upcoming.value
            verify(repository).getUpcoming()
            assertNotNull(moviesData)
            assertEquals(10, moviesData?.data?.size)

            viewModel.upcoming.observeForever(observerUpcoming)
            verify(observerUpcoming).onChanged(dummyMovies)
        }
    }
}