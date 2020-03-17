package com.codekinian.themovieapps.view.detail.tvshow

import com.codekinian.themovieapps.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailTvshowViewModelTest {

    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTv = DataDummy.generateDummyTvshows()[4]
    private val tvId = dummyTv.id

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel()
    }

    @Test
    fun getDetailTv() {
        // Memastikan tvId tidak null
        assertNotNull(tvId)

        // Mendefinisikan data
        val tvData = viewModel.getDetailTv(tvId)

        // Memastikan data tidak null
        assertNotNull(tvData)

        // Memastikan data dummy dengan data request
        assertEquals(dummyTv.id, tvData?.id)
        assertEquals(dummyTv.title, tvData?.title)
        assertEquals(dummyTv.overview, tvData?.overview)
        assertEquals(dummyTv.description, tvData?.description)
        assertEquals(dummyTv.poster_path, tvData?.poster_path)
        assertEquals(dummyTv.release_date, tvData?.release_date)
        assertEquals(dummyTv.percentage, tvData?.percentage)
    }
}