package com.codekinian.themovieapps.view.main.tab.movie.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.utils.Constant.Companion.MOVIE_ID
import com.codekinian.themovieapps.utils.getViewModel
import com.codekinian.themovieapps.utils.launchActivity
import com.codekinian.themovieapps.view.detail.movie.DetailMovieActivity
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabAdapter
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabViewModel
import kotlinx.android.synthetic.main.movie_viewpager_fragment.*

class NowPlayingFragment : Fragment() {
    private val viewModel by lazy {
        getViewModel {
            MovieTabViewModel()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_viewpager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movies.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MovieTabAdapter(viewModel.movies) {
                context.launchActivity<DetailMovieActivity> {
                    putExtra(MOVIE_ID, it)
                }
            }
        }
    }
}