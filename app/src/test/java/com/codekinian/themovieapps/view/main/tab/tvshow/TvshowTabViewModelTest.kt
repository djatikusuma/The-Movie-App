package com.codekinian.themovieapps.view.main.tab.tvshow

import com.codekinian.themovieapps.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvshowTabViewModelTest {

    private lateinit var viewModel: TvshowTabViewModel

    @Before
    fun setUp() {
        viewModel = TvshowTabViewModel()
    }

    @Test
    fun getTvshows() {
        // mendefinisikan data
        val tvData = viewModel.tvshows

        // Memastikan data tidak null
        assertNotNull(tvData)

        // Memastikan bahwa jumlah list data sebanyak 10
        assertEquals(10, tvData.size)

        // Memastikan data dummy sama dengan list data yang diperoleh
        assertEquals(DataDummy.generateDummyTvshows(), tvData)
    }
}