package com.codekinian.themovieapps.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.injectViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null) {
        ViewModelProvider(this)[T::class.java]
    } else {
        return ViewModelProvider(this, BaseViewModelFactory(creator))[T::class.java]
    }
}

inline fun <reified T : ViewModel> FragmentActivity.injectViewModel(noinline creator: (() -> T)? = null): T {
    return if (creator == null) {
        ViewModelProvider(this)[T::class.java]
    } else {
        return ViewModelProvider(this, BaseViewModelFactory(creator))[T::class.java]
    }
}