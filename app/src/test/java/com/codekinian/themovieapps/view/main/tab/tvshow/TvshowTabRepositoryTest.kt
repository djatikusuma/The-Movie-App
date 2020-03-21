package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.utils.LiveDataTestUtil
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
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
import org.mockito.Mockito.`when`

class TvshowTabRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(TvshowRemoteDataSource::class.java)
    private val scope = CoroutineScope(Dispatchers.IO)
    private val repository = FakeTvRepository(remote, scope)
    private val tvResponse = DataDummy.generateDummyTvshows()

    @Test
    fun getAiringToday() {
        scope.launch {
            `when`(remote.getAiringToday()).thenReturn(any())
            val tvshows = LiveDataTestUtil.getValue(repository.getAiringToday())
            verify(remote).getAiringToday()
            assertNotNull(tvshows)
            assertEquals(
                tvResponse.results.size.toLong(),
                tvshows.results.size.toLong()
            )
        }
    }

    @Test
    fun getOnTheAir() {
        scope.launch {
            `when`(remote.getOnTheAir()).thenReturn(any())
            val tvshows = LiveDataTestUtil.getValue(repository.getOnTheAir())
            verify(remote).getOnTheAir()
            assertNotNull(tvshows)
            assertEquals(
                tvResponse.results.size.toLong(),
                tvshows.results.size.toLong()
            )
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            `when`(remote.getPopular()).thenReturn(any())
            val tvshows = LiveDataTestUtil.getValue(repository.getPopular())
            verify(remote).getPopular()
            assertNotNull(tvshows)
            assertEquals(
                tvResponse.results.size.toLong(),
                tvshows.results.size.toLong()
            )
        }
    }

    @Test
    fun getDetailTv() {
        scope.launch {
            val tvId = tvResponse.results[0].id
            `when`(remote.getDetailTv(tvId)).thenReturn(any())
            val tvshow = LiveDataTestUtil.getValue(repository.getDetailTv(tvId))
            verify(remote).getDetailTv(tvId)
            assertNotNull(tvshow)
            assertEquals(tvResponse.results[0].name, tvshow.name)
        }
    }
}