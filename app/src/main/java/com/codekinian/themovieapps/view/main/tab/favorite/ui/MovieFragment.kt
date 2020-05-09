package com.codekinian.themovieapps.view.main.tab.favorite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.utils.*
import com.codekinian.themovieapps.view.detail.movie.DetailMovieActivity
import com.codekinian.themovieapps.view.main.tab.favorite.FavoriteTabViewModel
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabAdapter
import kotlinx.android.synthetic.main.movie_viewpager_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : Fragment() {

    private val viewModel by viewModel<FavoriteTabViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_viewpager_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapterMovies = MovieTabAdapter<Movie> {
            context?.launchActivity<DetailMovieActivity> {
                putExtra(Constant.MOVIE_ID, it)
                putExtra(Constant.MOVIE_CATEGORY, "favorite")
            }
        }

        progress_circular.show()
        viewModel.movies.observeForever { result ->
            when (result.status) {
                Result.Status.SUCCESS -> {
                    progress_circular.hide()
                    adapterMovies.submitList(result.data)
                    adapterMovies.notifyDataSetChanged()
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

        with(rv_movies) {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMovies
        }
    }
}