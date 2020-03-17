package com.codekinian.themovieapps.view.detail.movie

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.databinding.ActivityDetailMovieBinding
import com.codekinian.themovieapps.utils.Constant.Companion.MOVIE_ID
import com.codekinian.themovieapps.utils.getViewModel

class DetailMovieActivity : AppCompatActivity() {
    private val viewModel by lazy {
        getViewModel {
            DetailMovieViewModel()
        }
    }

    private val viewBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailMovieBinding>(
            this,
            R.layout.activity_detail_movie
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        setToolbar()
        createView()
    }

    private fun createView() {
        val movieId = intent.getIntExtra(MOVIE_ID, 0)
        viewBinding.lifecycleOwner = this
        viewBinding.movie = viewModel.getDetailMovie(movieId)
    }

    private fun setToolbar() {
        viewBinding.toolbar.title = getString(R.string.detail_label)
        viewBinding.toolbar.setTitleTextColor(Color.WHITE)
        this.setSupportActionBar(viewBinding.toolbar)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.setDisplayShowHomeEnabled(true)
        this.supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow)
        viewBinding.toolbar.setNavigationOnClickListener {
            finish()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}
