package com.codekinian.themovieapps.model.data.tvshows

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "on_the_air")
@Parcelize
data class OnTheAir(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "poster_path")
    val poster_path: String?,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "first_air_date")
    val first_air_date: String?,

    @ColumnInfo(name = "overview")
    val overview: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "vote_average")
    val vote_average: String?,

    @ColumnInfo(name = "isFavorite")
    val isFavorite: Boolean = false,

    @ColumnInfo(name = "status")
    val status: String? = null
) : Parcelable {
    data class Result(
        val results: List<OnTheAir>
    )
}