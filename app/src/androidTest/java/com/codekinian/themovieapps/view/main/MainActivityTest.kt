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
    private val dummyMovie = DataDummy.generateDummyNowPlaying()
    private val dummyTv = DataDummy.generateDummyNowPlaying()

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
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canLoadDataAndScrollDataMoviesInPopularMovieTab() {
        onView(withText("POPULAR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListPopularMovies() {
        onView(withText("POPULAR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailAndClickFavoriteWhenClickCardInListPopularMovies() {
        onView(withText("POPULAR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }

    @Test
    fun canLoadDataAndScrollDataMoviesInUpcomingMovieTab() {
        onView(withText("UPCOMING")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListUpcomingMovies() {
        onView(withText("UPCOMING")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                7,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailAndClickFavoriteWhenClickCardInListUpcomingMovies() {
        onView(withText("UPCOMING")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                7,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }

    @Test
    fun canOpenDetailWhenClickCardInListNowPlayingMovies() {
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailAndClickFavoriteWhenClickCardInListNowPlayingMovies() {
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }

    // Tvshow

    @Test
    fun canLoadDataAndScrollDataTvInTvshowsTab() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canLoadDataAndScrollDataTvInOnTheAirTvshowTab() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("ON THE AIR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListOnTheAirTvShows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("ON THE AIR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailAndClickFavoriteWhenClickCardInListOnTheAirTvShows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("ON THE AIR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }

    @Test
    fun canLoadDataAndScrollDataTvInPopularTvshowTab() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("POPULAR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun canOpenDetailWhenClickCardInListPopularTvShows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("POPULAR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailAndClickFavoriteWhenClickCardInListPopularTvShows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(withText("POPULAR")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                5,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }


    @Test
    fun canOpenDetailWhenClickCardInListAiringTodayTvshows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailAndClickFavoriteWhenClickCardInListAiringTodayTvshows() {
        onView(allOf(withId(R.id.navigation_tvshow))).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                2,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }

    // Favorite
    @Test
    fun canLoadDataFavoriteMovie() {
        onView(allOf(withId(R.id.navigation_favorite))).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailDataFavoriteMovie() {
        onView(allOf(withId(R.id.navigation_favorite))).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canClickFavoriteDataFavoriteMovie() {
        onView(allOf(withId(R.id.navigation_favorite))).perform(click())
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_movies), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_movie)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }

    @Test
    fun canLoadDataFavoriteTv() {
        onView(allOf(withId(R.id.navigation_favorite))).perform(click())
        onView(withText("TV SHOWS")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
    }

    @Test
    fun canOpenDetailDataFavoriteTv() {
        onView(allOf(withId(R.id.navigation_favorite))).perform(click())
        onView(withText("TV SHOWS")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun canClickFavoriteDataFavoriteTv() {
        onView(allOf(withId(R.id.navigation_favorite))).perform(click())
        onView(withText("TV SHOWS")).check(matches(isCompletelyDisplayed())).perform(click())
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed()))
        onView(allOf(withId(R.id.rv_tvshow), isCompletelyDisplayed())).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.title_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.description_tv)).check(matches(isCompletelyDisplayed()))
        onView(withId(R.id.action_favorite)).check(matches(isCompletelyDisplayed()))
            .perform(click())
    }
}