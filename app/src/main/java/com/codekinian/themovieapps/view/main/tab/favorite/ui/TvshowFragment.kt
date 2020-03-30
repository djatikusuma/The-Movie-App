package com.codekinian.themovieapps.view.main.tab.favorite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.utils.*
import com.codekinian.themovieapps.view.detail.tvshow.DetailTvshowActivity
import com.codekinian.themovieapps.view.main.tab.favorite.FavoriteTabRepository
import com.codekinian.themovieapps.view.main.tab.favorite.FavoriteTabViewModel
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabAdapter
import kotlinx.android.synthetic.main.movie_viewpager_fragment.progress_circular
import kotlinx.android.synthetic.main.tvshow_viewpager_fragment.*

class TvshowFragment : Fragment() {
    private val viewModel by lazy {
        injectViewModel {
            val theMovieDatabase = TheMovieDatabase.getInstance(context!!)
            FavoriteTabViewModel(
                FavoriteTabRepository.getInstance(
                    theMovieDatabase
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

    override fun onResume() {
        super.onResume()
        val adapterTv = TvshowTabAdapter<Tvshow> {
            context?.launchActivity<DetailTvshowActivity> {
                putExtra(Constant.TV_ID, it)
                putExtra(Constant.TV_CATEGORY, "favorite")
            }
        }

        viewModel.tvshows.observeForever { result ->
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