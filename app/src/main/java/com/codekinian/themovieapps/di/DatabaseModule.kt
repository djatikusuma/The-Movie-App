package com.codekinian.themovieapps.di

import android.app.Application
import androidx.room.Room
import com.codekinian.themovieapps.model.room.TheMovieDao
import com.codekinian.themovieapps.model.room.TheMovieDatabase
import com.codekinian.themovieapps.model.room.TheTvDao
import org.koin.dsl.module

val databaseModule = module {
    fun provideDatabase(application: Application): TheMovieDatabase {
        return Room.databaseBuilder(
            application,
            TheMovieDatabase::class.java,
            "AppMovieDatabaseTwo.db"
        )
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


    fun provideMovieDao(database: TheMovieDatabase): TheMovieDao {
        return database.theMovieDao()
    }

    fun provideTvDao(database: TheMovieDatabase): TheTvDao {
        return database.theTvDao()
    }

    single { provideDatabase(get()) }
    single { provideMovieDao(get()) }
    single { provideTvDao(get()) }
}