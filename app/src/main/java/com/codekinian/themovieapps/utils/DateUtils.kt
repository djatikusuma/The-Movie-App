package com.codekinian.themovieapps.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    @SuppressLint("SimpleDateFormat")
    @JvmStatic
    fun humanDate(date: String?): String {
        return if (!date.isNullOrEmpty()) {
            val parser = SimpleDateFormat("yyyy-M-dd", Locale.getDefault())
            val formatter = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())
            formatter.format(parser.parse(date)!!)
        } else {
            "-"
        }
    }
}