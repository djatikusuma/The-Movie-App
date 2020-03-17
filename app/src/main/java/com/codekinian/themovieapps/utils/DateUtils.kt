package com.codekinian.themovieapps.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat

object DateUtils {
    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    fun humanDate(date: String?): String {
        return if (!date.isNullOrEmpty()) {
            val parser = SimpleDateFormat("yyyy-M-dd")
            val formatter = SimpleDateFormat("MMM dd, yyyy")
            formatter.format(parser.parse(date))
        } else {
            "-"
        }
    }
}