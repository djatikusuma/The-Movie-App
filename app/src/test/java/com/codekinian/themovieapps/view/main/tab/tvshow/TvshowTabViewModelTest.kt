package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result
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
import org.mockito.Mockito.lenient
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
    private lateinit var observerAiringToday: Observer<Result<PagedList<AiringToday>>>

    @Mock
    private lateinit var pagedListAiringToday: PagedList<AiringToday>

    @Mock
    private lateinit var observerPopular: Observer<Result<PagedList<PopularTv>>>

    @Mock
    private lateinit var pagedListPopularTv: PagedList<PopularTv>

    @Mock
    private lateinit var observerOnTheAir: Observer<Result<PagedList<OnTheAir>>>

    @Mock
    private lateinit var pagedListOnTheAir: PagedList<OnTheAir>

    @Before
    fun setUp() {
        viewModel = TvshowTabViewModel(repository)
    }

    @Test
    fun getAiringToday() {
        scope.launch {
            val dummyTvshow = Result.success(pagedListAiringToday)
            lenient().`when`(dummyTvshow.data?.size).thenReturn(10)
            val tvshows = MutableLiveData<Result<PagedList<AiringToday>>>()
            tvshows.value = dummyTvshow

            lenient().`when`(repository.getAiringToday()).thenReturn(tvshows)
            val tvData = viewModel.airingToday.value?.data
            verify(repository).getAiringToday()
            assertNotNull(tvData)
            assertEquals(10, tvData?.size)

            viewModel.airingToday.observeForever(observerAiringToday)
            verify(observerAiringToday).onChanged(dummyTvshow)
        }
    }

    @Test
    fun getOnTheAir() {
        scope.launch {
            val dummyTvshow = Result.success(pagedListOnTheAir)
            lenient().`when`(dummyTvshow.data?.size).thenReturn(10)
            val tvshows = MutableLiveData<Result<PagedList<OnTheAir>>>()
            tvshows.value = dummyTvshow

            lenient().`when`(repository.getOnTheAir()).thenReturn(tvshows)
            val tvData = viewModel.onTheAir.value?.data
            verify(repository).getOnTheAir()
            assertNotNull(tvData)
            assertEquals(10, tvData?.size)

            viewModel.onTheAir.observeForever(observerOnTheAir)
            verify(observerOnTheAir).onChanged(dummyTvshow)
        }
    }

    @Test
    fun getPopular() {
        scope.launch {
            val dummyTvshow = Result.success(pagedListPopularTv)
            lenient().`when`(dummyTvshow.data?.size).thenReturn(10)
            val tvshows = MutableLiveData<Result<PagedList<PopularTv>>>()
            tvshows.value = dummyTvshow

            lenient().`when`(repository.getPopular()).thenReturn(tvshows)
            val tvData = viewModel.popularTv.value?.data
            verify(repository).getPopular()
            assertNotNull(tvData)
            assertEquals(10, tvData?.size)

            viewModel.popularTv.observeForever(observerPopular)
            verify(observerPopular).onChanged(dummyTvshow)
        }
    }
}