package com.codekinian.themovieapps.model.data.movies

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "popular_movie")
@Parcelize
data class PopularMovie(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "poster_path")
    val poster_path: String?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "release_date")
    val release_date: String?,

    @ColumnInfo(name = "overview")
    val overview: String? = null,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "vote_average")
    val vote_average: String?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,

    @ColumnInfo(name = "status")
    val status: String? = null
) : Parcelable {
    data class Result(
        val results: List<PopularMovie>
    )
}