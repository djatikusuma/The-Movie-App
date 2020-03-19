package com.codekinian.themovieapps.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val poster_path: String?,
    val title: String?,
    val release_date: String?,
    val overview: String? = null,
    val description: String?,
    val vote_average: String?,
    val status: String? = null
) : Parcelable {
    data class MovieResult(
        val results: List<Movie>
    )
}