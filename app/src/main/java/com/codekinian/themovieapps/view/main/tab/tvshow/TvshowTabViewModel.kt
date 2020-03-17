package com.codekinian.themovieapps.view.main.tab.tvshow

import androidx.lifecycle.ViewModel
import com.codekinian.themovieapps.model.Tvshow
import com.codekinian.themovieapps.utils.DataDummy

class TvshowTabViewModel : ViewModel() {
    // Get All TV Shows Data
    val tvshows: List<Tvshow> = DataDummy.generateDummyTvshows()
}
