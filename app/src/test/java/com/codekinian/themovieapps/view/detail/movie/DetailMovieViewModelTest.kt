package com.codekinian.themovieapps.view.detail.movie

import com.codekinian.themovieapps.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[2]
    private val movieId = dummyMovie.id

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
    }

    @Test
    fun getDetailMovie() {
        // Memastikan movieId tidak null
        assertNotNull(movieId)

        // Mendefinisikan data
        val movieData = viewModel.getDetailMovie(movieId)

        // Memastikan data tidak null
        assertNotNull(movieData)

        // Memastikan data dummy dengan data request
        assertEquals(dummyMovie.id, movieData?.id)
        assertEquals(dummyMovie.title, movieData?.title)
        assertEquals(dummyMovie.overview, movieData?.overview)
        assertEquals(dummyMovie.description, movieData?.description)
        assertEquals(dummyMovie.poster_path, movieData?.poster_path)
        assertEquals(dummyMovie.release_date, movieData?.release_date)
        assertEquals(dummyMovie.percentage, movieData?.percentage)
    }
}