package com.codekinian.themovieapps.view.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
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
class DetailTvshowViewModelTest {

    private lateinit var viewModel: DetailTvshowViewModel
    private val scope = CoroutineScope(Dispatchers.IO)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: TvshowTabRepository

    @Mock
    private lateinit var observer: Observer<Result<Tvshow>>

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(repository)
    }

    @Test
    fun getDetailTv() {
        scope.launch {
            val category = "airing_today"
            val tvId = DataDummy.generateDummyAiringToday()[0].id
            val dummyTv = Result.success(DataDummy.getTvshowById(tvId)!!)
            val tvshows = MutableLiveData<Result<Tvshow>>()
            tvshows.value = dummyTv

            `when`(repository.getDetailTv(category, tvId)).thenReturn(tvshows)
            val moviesData = viewModel.detailTv(category, tvId).value
            verify(repository).getDetailTv(category, tvId)
            assertNotNull(moviesData)
            assertNotNull(dummyTv)
            val title = moviesData?.data?.name
            val dummyTitle = dummyTv.data?.name
            assertNotNull(title)
            assertNotNull(dummyTitle)
            TestCase.assertEquals(title, dummyTitle)

            viewModel.detailTv(category, tvId).observeForever(observer)
            verify(observer).onChanged(dummyTv)
        }
    }
}