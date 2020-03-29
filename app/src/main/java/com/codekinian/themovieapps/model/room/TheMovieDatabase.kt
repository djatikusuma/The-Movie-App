package com.codekinian.themovieapps.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codekinian.themovieapps.model.data.Movie
import com.codekinian.themovieapps.model.data.Tvshow

@Database(
    entities = [Movie::class, Tvshow::class],
    version = 1,
    exportSchema = false
)
abstract class TheMovieDatabase : RoomDatabase() {
    abstract fun theMovieDao(): TheMovieDao

    companion object {

        @Volatile
        private var INSTANCE: TheMovieDatabase? = null

        fun getInstance(context: Context): TheMovieDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    TheMovieDatabase::class.java,
                    "TheMovie.db"
                ).build()
            }
    }
}