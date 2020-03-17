package com.codekinian.themovieapps.view.main.tab.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.utils.Constant
import com.codekinian.themovieapps.utils.getViewModel
import com.codekinian.themovieapps.utils.launchActivity
import com.codekinian.themovieapps.view.detail.tvshow.DetailTvshowActivity
import kotlinx.android.synthetic.main.tvshow_tab_fragment.*

class TvshowTabFragment : Fragment() {

    private val viewModel by lazy {
        getViewModel {
            TvshowTabViewModel()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.tvshow_tab_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_tvshow.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = TvshowTabAdapter(viewModel.tvshows) {
                context.launchActivity<DetailTvshowActivity> {
                    putExtra(Constant.TV_ID, it)
                }
            }
        }
    }

}
