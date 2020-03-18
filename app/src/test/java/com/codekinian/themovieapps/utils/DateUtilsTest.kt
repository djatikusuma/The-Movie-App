package com.codekinian.themovieapps.utils

import org.junit.Assert.*
import org.junit.Test

class DateUtilsTest {

    @Test
    fun ifEmptyReturnStrip() {
        val releaseDate = ""

        // Memeriksa release date tidak null
        assertNotNull(releaseDate)

        // Memeriksa apakah hasil konversi sama
        assertEquals(DateUtils.humanDate(releaseDate), "-")
    }

    @Test
    fun ifNullReturnStrip() {
        val releaseDate = null

        // Memeriksa apakah hasil konversi sama
        assertEquals(DateUtils.humanDate(releaseDate), "-")
    }

    @Test
    fun ifNotNullOrEmptyReturnDate() {
        val releaseDate = "2019-03-11"

        // Memeriksa release date tidak null
        assertNotNull(releaseDate)

        // Memeriksa apakah hasil konversi sama
        assertNotEquals(DateUtils.humanDate(releaseDate), "-")
    }
}