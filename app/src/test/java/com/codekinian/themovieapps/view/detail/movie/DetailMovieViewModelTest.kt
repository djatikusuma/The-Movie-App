package com.codekinian.themovieapps.view.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabRepository
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
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val scope = CoroutineScope(Dispatchers.IO)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieTabRepository

    @Mock
    private lateinit var observer: Observer<Result<Movie>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
    }

    @Test
    fun getDetailMovie() {
        scope.launch {
            val category = "now_playing"
            val movieId = DataDummy.generateDummyNowPlaying()[0].id
            val dummyMovies = Result.success(DataDummy.getMovieById(movieId)!!)
            val movies = MutableLiveData<Result<Movie>>()
            movies.value = dummyMovies

            `when`(repository.getDetailMovie(category, movieId)).thenReturn(movies)
            val moviesData = viewModel.detailMovie(category, movieId).value
            verify(repository).getDetailMovie(category, movieId)
            assertNotNull(moviesData)
            assertNotNull(dummyMovies)
            val title = moviesData?.data?.title
            val dummyTitle = dummyMovies.data?.title
            assertNotNull(title)
            assertNotNull(dummyTitle)
            assertEquals(dummyTitle, title)

            viewModel.detailMovie(category, movieId).observeForever(observer)
            verify(observer).onChanged(dummyMovies)
        }
    }
}