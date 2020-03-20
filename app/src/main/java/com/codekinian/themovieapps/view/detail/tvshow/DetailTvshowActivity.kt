package com.codekinian.themovieapps.view.detail.tvshow

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.databinding.ActivityDetailTvshowBinding
import com.codekinian.themovieapps.utils.Constant
import com.codekinian.themovieapps.utils.injectViewModel

class DetailTvshowActivity : AppCompatActivity() {
    private val viewModel by lazy {
        injectViewModel {
            DetailTvshowViewModel()
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
        viewBinding.tv = viewModel.getDetailTv(tvId)
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
