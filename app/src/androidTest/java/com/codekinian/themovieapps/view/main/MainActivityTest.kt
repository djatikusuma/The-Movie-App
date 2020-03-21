package com.codekinian.themovieapps.view.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.codekinian.themovieapps.R
import com.codekinian.themovieapps.utils.DataDummy
import com.codekinian.themovieapps.utils.EspressoIdlingResource
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies().results
    private val dummyTv = DataDummy.generateDummyTvshows().results

    @get:Rule
    var activtiyRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun canLoadDataAndScrollDataMoviesInMovieTab() {
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canLoadDataAndScrollDataMoviesInPopularMovieTab() {
        onView(withText("POPULAR")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListPopularMovies() {
        onView(withText("POPULAR")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun canLoadDataAndScrollDataMoviesInUpcomingMovieTab() {
        onView(withText("UPCOMING")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListUpcomingMovies() {
        onView(withText("UPCOMING")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                7,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun canOpenDetailWhenClickCardInListNowPlayingMovies() {
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun canLoadDataAndScrollDataTvInTvshowsTab() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canLoadDataAndScrollDataTvInOnTheAirTvshowTab() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("ON THE AIR")).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListOnTheAirTvShows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("ON THE AIR")).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isDisplayed()))
    }

    @Test
    fun canLoadDataAndScrollDataTvInPopularTvshowTab() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("POPULAR")).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListPopularTvShows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("POPULAR")).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isDisplayed()))
    }


    @Test
    fun canOpenDetailWhenClickCardInListAiringTodayTvshows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isDisplayed()))
    }

}