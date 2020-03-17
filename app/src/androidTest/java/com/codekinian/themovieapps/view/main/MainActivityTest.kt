package com.codekinian.themovieapps.view.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateDummyTvshows()

    @get:Rule
    var activtiyRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun canLoadDataAndScrollDataMoviesInMovieTab() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListMovies() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.title_movie)).check(matches(withText(dummyMovie[2].title)))
        onView(withId(R.id.description_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(withText(dummyMovie[2].description)))
    }

    @Test
    fun canChangeTabThenLoadDataAndScrollDataTvShowsInTvShowsTab() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListTvshows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                4,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.title_tv)).check(matches(withText(dummyTv[4].title)))
        onView(withId(R.id.description_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(withText(dummyTv[4].description)))
    }
}