package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codekinian.themovieapps.model.room.TheTvDao
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

    private val theTvDao = Mockito.mock(TheTvDao::class.java)
    private val remote = Mockito.mock(TvshowRemoteDataSource::class.java)
    private val scope = CoroutineScope(Dispatchers.IO)
    private val repository = FakeTvshowTabRepository(theTvDao, remote, scope)
    private val airingToday = DataDummy.generateDummyAiringToday()
    private val onTheAir = DataDummy.generateDummyOnTheAir()
    private val popularTv = DataDummy.generateDummyPopularTv()

    @Test
    fun getAiringToday() {
        scope.launch {
            `when`(remote.getAiringToday()).thenReturn(any())
            val tvshows = LiveDataTestUtil.getValue(repository.getAiringToday())
            verify(remote).getAiringToday()
            assertNotNull(tvshows)
            assertEquals(
                airingToday.size.toLong(),
                tvshows.data?.size?.toLong()
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
                onTheAir.size.toLong(),
                tvshows.data?.size?.toLong()
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
                popularTv.size.toLong(),
                tvshows.data?.size?.toLong()
            )
        }
    }

    @Test
    fun getDetailTv() {
        scope.launch {
            val tvId = airingToday[0].id
            `when`(remote.getDetailTv(tvId)).thenReturn(any())
            val tvshow = LiveDataTestUtil.getValue(repository.getDetailTv("airing_today", tvId))
            verify(remote).getDetailTv(tvId)
            assertNotNull(tvshow)
            assertEquals(airingToday[0].name, tvshow.data?.name)
        }
    }
}