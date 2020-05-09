package com.codekinian.themovieapps.view.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.response.Result
import com.codekinian.themovieapps.view.main.tab.tvshow.TvshowTabRepository

class DetailTvshowViewModel(private val repository: TvshowTabRepository) : ViewModel() {
    private val tvId = MutableLiveData<Int>()
    val isFavoriteTv = Transformations.switchMap(tvId) { repository.getFavoriteTvById(it) }

    fun setTvId(movieId: Int) {
        this.tvId.value = movieId
    }
    fun detailTv(category: String, tvId: Int): LiveData<Result<Tvshow>> =
        repository.getDetailTv(category, tvId)

    fun setFavoriteTv() {
        isFavoriteTv.value?.let {
            val favoriteState = !it.isFavorite
            repository.setFavoriteTv(it, favoriteState)
        }
    }
}