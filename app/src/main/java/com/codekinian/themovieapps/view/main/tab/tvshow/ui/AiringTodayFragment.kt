package com.codekinian.themovieapps.view.main.tab.tvshow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.network.BaseApi
import com.codekinian.themovieapps.utils.*
import com.codekinian.themovieapps.view.detail.tvshow.DetailTvshowActivity
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabAdapter
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabViewModel
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
import kotlinx.android.synthetic.main.movie_viewpager_fragment.progress_circular
import kotlinx.android.synthetic.main.tvshow_viewpager_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class AiringTodayFragment : Fragment() {
    private val viewModel by lazy {
        injectViewModel {
            val remoteDataSource = TvshowRemoteDataSource.getInstance(BaseApi().api)
            TvshowTabViewModel(
                TvshowTabRepository.getInstance(
                    remoteDataSource, CoroutineScope(
                        Dispatchers.IO
                    )
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tvshow_viewpager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapterTv = TvshowTabAdapter {
            context?.launchActivity<DetailTvshowActivity> {
                putExtra(Constant.TV_ID, it)
            }
        }

        progress_circular.show()
        viewModel.airingToday.observeForever { tv ->
            progress_circular.hide()
            adapterTv.updateData(tv.results)
        }

        with(rv_tvshow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterTv
        }
    }
}