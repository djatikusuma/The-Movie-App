package com.codekinian.themovieapps.view.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.Movie
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
import org.mockito.Mockito
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
    private lateinit var observer: Observer<Movie>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
    }

    @Test
    fun getDetailMovie() {
        scope.launch {
            val movieId = DataDummy.generateDummyMovies().results[0].id
            val dummyMovies = DataDummy.getMovieById(movieId)
            val movies = MutableLiveData<Movie>()
            movies.value = dummyMovies

            Mockito.`when`(repository.getDetailMovie(movieId)).thenReturn(movies)
            val moviesData = viewModel.detailMovie(movieId).value
            verify(repository).getDetailMovie(movieId)
            assertNotNull(moviesData)
            assertNotNull(dummyMovies)
            val title = moviesData?.title
            val dummyTitle = dummyMovies?.title
            assertNotNull(title)
            assertNotNull(dummyTitle)
            assertEquals(dummyTitle, title)

            viewModel.detailMovie(movieId).observeForever(observer)
            verify(observer).onChanged(dummyMovies)
        }
    }
}