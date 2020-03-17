package com.codekinian.themovieapps.view.main.tab.movie

import com.codekinian.themovieapps.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieTabViewModelTest {

    private lateinit var viewModel: MovieTabViewModel

    @Before
    fun setUp() {
        viewModel = MovieTabViewModel()
    }

    @Test
    fun getMovies() {
        // mendefinisikan data
        val movieData = viewModel.movies

        // Memastikan data tidak null
        assertNotNull(movieData)

        // Memastikan bahwa jumlah list data sebanyak 10
        assertEquals(10, movieData.size)

        // Memastikan data dummy sama dengan list data yang diperoleh
        assertEquals(DataDummy.generateDummyMovies(), movieData)
    }
}