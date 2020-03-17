package com.codekinian.themovieapps.view.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.view.main.tab.movie.MovieTabFragment
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabFragment

class MainViewPager(
    viewPagerManager: FragmentManager,
    private val context: Context
) : FragmentStatePagerAdapter(
    viewPagerManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> MovieTabFragment()
        else -> TvshowTabFragment()
    }

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.label_movies)
        else -> context.getString(R.string.label_tvshows)
    }
}