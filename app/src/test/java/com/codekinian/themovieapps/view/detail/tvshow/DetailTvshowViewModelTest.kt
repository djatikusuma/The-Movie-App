package com.codekinian.themovieapps.view.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.codekinian.themovieapps.model.data.Tvshow
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
    private lateinit var observer: Observer<Tvshow>

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(repository)
    }

    @Test
    fun getDetailTv() {
        scope.launch {
            val tvId = DataDummy.generateDummyTvshows().results[0].id
            val dummyTv = DataDummy.getTvById(tvId)
            val tvshows = MutableLiveData<Tvshow>()
            tvshows.value = dummyTv

            `when`(repository.getDetailTv(tvId)).thenReturn(tvshows)
            val moviesData = viewModel.detailTv(tvId).value
            verify(repository).getDetailTv(tvId)
            assertNotNull(moviesData)
            assertNotNull(dummyTv)
            val title = moviesData?.name
            val dummyTitle = dummyTv?.name
            assertNotNull(title)
            assertNotNull(dummyTitle)
            TestCase.assertEquals(title, dummyTitle)

            viewModel.detailTv(tvId).observeForever(observer)
            verify(observer).onChanged(dummyTv)
        }
    }
}