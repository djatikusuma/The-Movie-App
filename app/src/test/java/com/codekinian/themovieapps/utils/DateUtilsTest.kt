package com.codekinian.themovieapps.utils

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DateUtilsTest {

    @Test
    fun humanDate() {
        val releaseDate = "2019-12-03"

        // Memeriksa release date tidak null
        assertNotNull(releaseDate)

        // Memeriksa apakah hasil konversi sama
        assertEquals(DateUtils.humanDate(releaseDate), "Des 03, 2019")
    }
}