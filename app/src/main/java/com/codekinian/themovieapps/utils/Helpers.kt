package com.codekinian.themovieapps.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.codekinian.themovieapps.BuildConfig
import com.codekinian.themovieapps.R

object Helpers {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, img: String?) {
        if (img != null) Glide.with(view.context).load(BuildConfig.IMAGE_URL + "/w500" + img)
            .placeholder(R.drawable.placeholder_large).into(view)
    }

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(view: ImageView, img: Int?) {
        if (img != null) Glide.with(view.context).load(img)
            .placeholder(R.drawable.placeholder_large).into(view)
    }
}