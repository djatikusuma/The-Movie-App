package com.codekinian.themovieapps.view.main.tab.movie.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.network.BaseApi
import com.codekinian.themovieapps.utils.*
import com.codekinian.themovieapps.view.detail.movie.DetailMovieActivity
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabAdapter
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabRepository
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabViewModel
import com.codekinian.themovieapps.view.main.tab.movie.data.MovieRemoteDataSource
import kotlinx.android.synthetic.main.movie_viewpager_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class PopularFragment : Fragment() {
    private val viewModel by lazy {
        injectViewModel {
            val remoteDataSource = MovieRemoteDataSource.getInstance(BaseApi().api)
            MovieTabViewModel(
                MovieTabRepository.getInstance(
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
        return inflater.inflate(R.layout.movie_viewpager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapterMovies = MovieTabAdapter {
            context?.launchActivity<DetailMovieActivity> {
                putExtra(Constant.MOVIE_ID, it)
            }
        }

        progress_circular.show()
        viewModel.popular.observeForever { movies ->
            progress_circular.hide()
            adapterMovies.updateData(movies.results)
        }

        with(rv_movies) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterMovies
        }
    }
}