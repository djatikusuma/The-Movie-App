package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.utils.DataDummy
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
class TvshowTabViewModelTest {

    private lateinit var viewModel: TvshowTabViewModel
    private val scope = CoroutineScope(Dispatchers.IO)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: TvshowTabRepository

    @Mock
    private lateinit var observer: Observer<Tvshow.TvResult>

    @Before
    fun setUp() {
        viewModel = TvshowTabViewModel(repository)
    }

    @Test
    fun getAiringToday() {
        scope.launch {
            val dummyTvshow = DataDummy.generateDummyTvshows()
            val tvshows = MutableLiveData<Tvshow.TvResult>()
            tvshows.value = dummyTvshow

            `when`(repository.getAiringToday()).thenReturn(tvshows)
            val tvData = viewModel.airingToday.value
            verify(repository).getAiringToday()
            assertNotNull(tvData)
            assertEquals(10, tvData?.results?.size)

            viewModel.airingToday.observeForever(observer)
            verify(observer).onChanged(dummyTvshow)
        }
    }

    @Test
    fun getOnTheAir() {
        scope.launch {
            val dummyTvshow = DataDummy.generateDummyTvshows()
            val tvshows = MutableLiveData<Tvshow.TvResult>()
            tvshows.value = dummyTvshow

            `when`(repository.getOnTheAir()).thenReturn(tvshows)
            val tvData = viewModel.onTheAir.value
            verify(repository).getOnTheAir()
            assertNotNull(tvData)
            assertEquals(10, tvData?.results?.size)

            viewModel.onTheAir.observeForever(observer)
            verify(observer).onChanged(dummyTvshow)
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            val dummyTvshow = DataDummy.generateDummyTvshows()
            val tvshows = MutableLiveData<Tvshow.TvResult>()
            tvshows.value = dummyTvshow

            `when`(repository.getPopular()).thenReturn(tvshows)
            val tvData = viewModel.popularTv.value
            verify(repository).getPopular()
            assertNotNull(tvData)
            assertEquals(10, tvData?.results?.size)

            viewModel.popularTv.observeForever(observer)
            verify(observer).onChanged(dummyTvshow)
        }
    }
}