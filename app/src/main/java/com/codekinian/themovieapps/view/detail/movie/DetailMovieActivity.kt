package com.codekinian.themovieapps.view.detail.movie

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.databinding.ActivityDetailMovieBinding
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.utils.Constant.Companion.MOVIE_CATEGORY
import com.codekinian.themovieapps.utils.Constant.Companion.MOVIE_ID
import com.codekinian.themovieapps.utils.hide
import com.codekinian.themovieapps.utils.show
import com.codekinian.themovieapps.utils.toast
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    private val viewModel by viewModel<DetailMovieViewModel>()

    private val viewBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailMovieBinding>(
            this,
            R.layout.activity_detail_movie
        )
    }

    private lateinit var menu: Menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        setToolbar()
        createView()
    }

    private fun createView() {
        val movieId = intent.getIntExtra(MOVIE_ID, 0)
        val category = intent.getStringExtra(MOVIE_CATEGORY)
        viewBinding.lifecycleOwner = this
        category?.let { cat ->
            viewModel.detailMovie(cat, movieId).observeForever { result ->
                when (result.status) {
                    Result.Status.SUCCESS -> {
                        viewBinding.progressCircular.hide()
                        viewBinding.viewDetail.show()
                        viewBinding.movie = result.data

                        result.data?.let {
                            viewModel.setMovieId(it.id)
                        }
                    }
                    Result.Status.LOADING -> {
                        viewBinding.progressCircular.show()
                        viewBinding.viewDetail.hide()
                    }
                    Result.Status.ERROR -> {
                        viewBinding.progressCircular.hide()
                        viewBinding.viewDetail.hide()
                        toast("Gagal memuat data!")
                    }
                }
            }
        }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        menu?.let { this.menu = it }
        viewModel.isFavoriteMovie.observeForever {
            it?.let {
                setIconFavorite(it.isFavorite)
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavoriteMovie()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setIconFavorite(state: Boolean) {
        val menuItem = menu.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.star_active)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.star)
        }
    }
}
