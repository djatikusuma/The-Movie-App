package com.codekinian.themovieapps.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val poster_path: Int?,
    val title: String?,
    val release_date: String?,
    val overview: String?,
    val description: String?,
    val percentage: String?
) : Parcelable