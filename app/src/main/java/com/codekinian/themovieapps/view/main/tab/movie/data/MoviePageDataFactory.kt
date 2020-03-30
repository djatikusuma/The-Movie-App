package com.codekinian.themovieapps.view.main.tab.movie.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope

class MoviePageDataFactory<A>(
    private val category: String,
    private val dataSource: MovieRemoteDataSource,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, Any>() {

    override fun create(): DataSource<Int, Any> {
        val source = MoviePageDataSource(category, dataSource, scope)
        liveData.postValue(source)
        return source
    }

    companion object {
        private const val PAGE_SIZE = 10
        val liveData = MutableLiveData<MoviePageDataSource>()

        fun pagedListConfig(): PagedList.Config = PagedList.Config.Builder()
            .setInitialLoadSizeHint(PAGE_SIZE)
            .setPageSize(PAGE_SIZE)
            .setEnablePlaceholders(true)
            .build()
    }

}