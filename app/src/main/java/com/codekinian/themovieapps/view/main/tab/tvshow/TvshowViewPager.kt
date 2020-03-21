package com.codekinian.themovieapps.view.main.tab.tvshow

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.view.main.tab.tvshow.ui.AiringTodayFragment
import com.codekinian.themovieapps.view.main.tab.tvshow.ui.OnTheAirFragment
import com.codekinian.themovieapps.view.main.tab.tvshow.ui.PopularTvFragment

class TvshowViewPager(
    viewPagerManager: FragmentManager,
    private val context: Context
) : FragmentPagerAdapter(
    viewPagerManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment = when (position) {
        0 -> AiringTodayFragment()
        1 -> OnTheAirFragment()
        else -> PopularTvFragment()
    }

    override fun getCount(): Int = 3

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> context.getString(R.string.label_airing_today)
        1 -> context.getString(R.string.label_on_the_air)
        else -> context.getString(R.string.label_popular)
    }
}