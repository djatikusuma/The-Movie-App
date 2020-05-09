package com.codekinian.themovieapps.view.main.tab.movie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.model.data.movies.PopularMovie
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.utils.*
import com.codekinian.themovieapps.view.detail.movie.DetailMovieActivity
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabAdapter
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabViewModel
import kotlinx.android.synthetic.main.movie_viewpager_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class PopularFragment : Fragment() {
    /*private val viewModel by lazy {
        injectViewModel {
            val remoteDataSource = MovieRemoteDataSource.getInstance(BaseApi().api)
            val theMovieDao = TheMovieDatabase.getInstance(context!!).theMovieDao()
            MovieTabViewModel(
                MovieTabRepository.getInstance(
                    theMovieDao, remoteDataSource, CoroutineScope(
                        Dispatchers.IO
                    )
                )
            )
        }
    }*/

    private val viewModel by viewModel<MovieTabViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_viewpager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapterMovies = MovieTabAdapter<PopularMovie> {
            context?.launchActivity<DetailMovieActivity> {
                putExtra(Constant.MOVIE_ID, it)
                putExtra(Constant.MOVIE_CATEGORY, "popular")
            }
        }

        progress_circular.show()
        viewModel.popular.observeForever { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    progress_circular?.let {
                        progress_circular.hide()
                    }
                    adapterMovies.submitList(result.data)
                    adapterMovies.notifyDataSetChanged()
                }
                Result.Status.ERROR -> {
                    progress_circular?.let {
                        progress_circular.hide()
                    }
                    activity?.toast("Gagal memuat data!")
                }
                Result.Status.LOADING -> {
                    progress_circular.show()
                }
            }
        }

        with(rv_movies) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = adapterMovies
        }
    }
}