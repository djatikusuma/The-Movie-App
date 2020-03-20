package com.codekinian.themovieapps.view.main.tab.movie

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.view.main.tab.movie.viewpager.NowPlayingFragment
import com.codekinian.themovieapps.view.main.tab.movie.viewpager.PopularFragment
import com.codekinian.themovieapps.view.main.tab.movie.viewpager.UpcomingFragment

class MovieViewPager(
    viewPagerManager: FragmentManager,
    private val context: Context
) : FragmentPagerAdapter(
    viewPagerManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> NowPlayingFragment()
        1 -> PopularFragment()
        else -> UpcomingFragment()
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.label_now_playing)
        1 -> context.getString(R.string.label_popular)
        else -> context.getString(R.string.label_upcoming)
    }
}