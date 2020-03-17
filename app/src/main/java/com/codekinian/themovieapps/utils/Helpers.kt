package com.codekinian.themovieapps.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object Helpers {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, img: Int?) {
        if (img != null) Glide.with(view.context).load(img).into(view)
    }
}