package com.codekinian.themovieapps.view.main.tab.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.utils.getViewModel
import kotlinx.android.synthetic.main.movie_tab_fragment.*

class MovieTabFragment : Fragment() {
    private val viewModel by lazy {
        getViewModel {
            MovieTabViewModel()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_tab_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewPager()
    }

    private fun initViewPager() {
        var indicatorWidth = 0
        viewpager.apply {
            adapter = MovieViewPager(childFragmentManager, context)
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
//                    toolbar.title = when (position) {
//                        0 -> context.getString(R.string.label_movies)
//                        else -> context.getString(R.string.label_tvshows)
//                    }
                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })
        }
    }

}
