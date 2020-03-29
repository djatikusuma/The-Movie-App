package com.codekinian.themovieapps.view.main.tab.tvshow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.network.BaseApi
import com.codekinian.themovieapps.utils.*
import com.codekinian.themovieapps.view.detail.tvshow.DetailTvshowActivity
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabAdapter
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabViewModel
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
import kotlinx.android.synthetic.main.movie_viewpager_fragment.progress_circular
import kotlinx.android.synthetic.main.tvshow_viewpager_fragment.*

class PopularTvFragment : Fragment() {
    private val viewModel by lazy {
        injectViewModel {
            val remoteDataSource = TvshowRemoteDataSource.getInstance(BaseApi().api)
            val theTvDao = TheMovieDatabase.getInstance(context!!).theTvDao()
            TvshowTabViewModel(
                TvshowTabRepository.getInstance(
                    theTvDao, remoteDataSource
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
        val adapterTv = TvshowTabAdapter<PopularTv> {
            context?.launchActivity<DetailTvshowActivity> {
                putExtra(Constant.TV_ID, it)
                putExtra(Constant.TV_CATEGORY, "popular")
            }
        }

        progress_circular.show()
        viewModel.popularTv.observeForever { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    progress_circular.hide()
                    adapterTv.updateData(result.data)
                }
                Result.Status.ERROR -> {
                    progress_circular.hide()
                    activity?.toast("Gagal memuat data!")
                }
                Result.Status.LOADING -> {
                    progress_circular.show()
                }
            }
        }

        with(rv_tvshow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterTv
        }
    }
}