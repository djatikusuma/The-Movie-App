package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.DataSource
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheTvDao
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.utils.LiveDataTestUtil
import com.codekinian.themovieapps.utils.PagedListUtil
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class TvshowTabRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val theTvDao = mock(TheTvDao::class.java)
    private val remote = mock(TvshowRemoteDataSource::class.java)
    private val scope = CoroutineScope(Dispatchers.IO)
    private val repository = FakeTvshowTabRepository(theTvDao, remote, scope)
    private val airingToday = DataDummy.generateDummyAiringToday()
    private val onTheAir = DataDummy.generateDummyOnTheAir()
    private val popularTv = DataDummy.generateDummyPopularTv()

    @Test
    fun getAiringToday() {
        scope.launch {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, AiringToday>
            `when`(theTvDao.getAiringToday()).thenReturn(dataSourceFactory)

            val tvshows = LiveDataTestUtil.getValue(repository.getAiringToday())
            verify(remote).getAiringToday()
            assertNotNull(tvshows)

            val tvshow =
                Result.success(PagedListUtil.mockPagedList(DataDummy.generateDummyAiringToday()))
            verify(theTvDao).getAiringToday()
            assertNotNull(tvshow.data)
            assertEquals(airingToday.size.toLong(), tvshow.data?.size?.toLong())
        }
    }

    @Test
    fun getOnTheAir() {
        scope.launch {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, OnTheAir>
            `when`(theTvDao.getOnTheAir()).thenReturn(dataSourceFactory)

            val tvshows = LiveDataTestUtil.getValue(repository.getOnTheAir())
            verify(remote).getOnTheAir()
            assertNotNull(tvshows)

            val tvshow =
                Result.success(PagedListUtil.mockPagedList(DataDummy.generateDummyOnTheAir()))
            verify(theTvDao).getOnTheAir()
            assertNotNull(tvshow.data)
            assertEquals(onTheAir.size.toLong(), tvshow.data?.size?.toLong())
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, PopularTv>
            `when`(theTvDao.getPopularTv()).thenReturn(dataSourceFactory)

            val tvshows = LiveDataTestUtil.getValue(repository.getPopular())
            verify(remote).getPopular()
            assertNotNull(tvshows)

            val tvshow =
                Result.success(PagedListUtil.mockPagedList(DataDummy.generateDummyPopularTv()))
            verify(theTvDao).getPopularTv()
            assertNotNull(tvshow.data)
            assertEquals(popularTv.size.toLong(), tvshow.data?.size?.toLong())
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