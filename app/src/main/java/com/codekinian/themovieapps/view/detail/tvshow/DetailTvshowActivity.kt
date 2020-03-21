package com.codekinian.themovieapps.view.detail.tvshow

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.databinding.ActivityDetailTvshowBinding
import com.codekinian.themovieapps.network.BaseApi
import com.codekinian.themovieapps.utils.Constant
import com.codekinian.themovieapps.utils.injectViewModel
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository
import com.codekinian.themovieapps.view.main.tab.tvshow.data.TvshowRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class DetailTvshowActivity : AppCompatActivity() {
    private val viewModel by lazy {
        injectViewModel {
            val remoteDataSource = TvshowRemoteDataSource.getInstance(BaseApi().api)
            DetailTvshowViewModel(
                TvshowTabRepository.getInstance(
                    remoteDataSource, CoroutineScope(
                        Dispatchers.IO
                    )
                )
            )
        }
    }

    private val viewBinding by lazy {
        DataBindingUtil.setContentView<ActivityDetailTvshowBinding>(
            this,
            R.layout.activity_detail_tvshow
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        setToolbar()
        createView()
    }

    private fun createView() {
        val tvId = intent.getIntExtra(Constant.TV_ID, 0)
        viewBinding.lifecycleOwner = this
        viewModel.detailTv(tvId).observeForever {
            viewBinding.tv = it
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
}
