package com.codekinian.themovieapps.model.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tvshow(
    val id: Int,
    val poster_path: String?,
    val name: String?,
    val first_air_date: String?,
    val overview: String?,
    val description: String?,
    val vote_average: String?,
    val status: String? = null
) : Parcelable {
    data class TvResult(
        val results: List<Tvshow>
    )
}