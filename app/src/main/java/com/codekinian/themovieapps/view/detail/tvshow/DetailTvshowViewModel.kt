package com.codekinian.themovieapps.view.detail.tvshow

import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.Tvshow
import com.codekinian.themovieapps.utils.DataDummy

class DetailTvshowViewModel : ViewModel() {
    fun getDetailTv(id: Int): Tvshow? = DataDummy.getTvById(id)
}