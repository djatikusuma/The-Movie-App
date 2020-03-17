package com.codekinian.themovieapps.view.main

import android.graphics.Color
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.codekinian.themovieapps.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setToolbar()
        initViewPager()
    }

    private fun setToolbar() {
        toolbar.title = getString(R.string.label_movies)
        toolbar.setTitleTextColor(Color.WHITE)
    }

    private fun initViewPager() {
        var indicatorWidth = 0
        viewpager.apply {
            adapter = MainViewPager(supportFragmentManager, context)
            tab.setupWithViewPager(this, true)
            tab.post {
                indicatorWidth = tab.width / tab.tabCount
                val indicatorParams = indicator.layoutParams as FrameLayout.LayoutParams
                indicatorParams.width = indicatorWidth
                indicator.layoutParams = indicatorParams
            }
            addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    val params = indicator.layoutParams as FrameLayout.LayoutParams
                    val translationOffset: Float = (positionOffset + position) * indicatorWidth
                    params.leftMargin = translationOffset.toInt()
                    indicator.layoutParams = params
                }

                override fun onPageSelected(position: Int) {
                    toolbar.title = when (position) {
                        0 -> context.getString(R.string.label_movies)
                        else -> context.getString(R.string.label_tvshows)
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })
        }
    }
}
