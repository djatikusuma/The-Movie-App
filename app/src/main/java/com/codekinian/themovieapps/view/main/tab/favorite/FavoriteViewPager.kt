package com.codekinian.themovieapps.view.main.tab.favorite

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.view.main.tab.favorite.ui.MovieFragment
import com.codekinian.themovieapps.view.main.tab.favorite.ui.TvshowFragment

class FavoriteViewPager(
    viewPagerManager: FragmentManager,
    private val context: Context
) : FragmentPagerAdapter(
    viewPagerManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> MovieFragment()
        else -> TvshowFragment()
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.label_movies)
        else -> context.getString(R.string.label_tvshows)
    }
}