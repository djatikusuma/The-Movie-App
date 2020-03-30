package com.codekinian.themovieapps.view.main.tab.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.themovieapps.databinding.TvshowItemBinding
import com.codekinian.themovieapps.model.data.Tvshow
import com.codekinian.themovieapps.model.data.tvshows.AiringToday
import com.codekinian.themovieapps.model.data.tvshows.OnTheAir
import com.codekinian.themovieapps.model.data.tvshows.PopularTv
import com.codekinian.themovieapps.utils.DateUtils
import com.codekinian.themovieapps.utils.Helpers
import kotlinx.android.extensions.LayoutContainer

class TvshowTabAdapter<A>(
    private val onClick: (Int) -> Unit
) : PagedListAdapter<A, TvshowTabAdapter<A>.ViewHolder>(TvShowCallback<A>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        TvshowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvshows = getItem(position)
        tvshows?.let {
            holder.bindItem(it)
        }
    }

    inner class ViewHolder(private val view: TvshowItemBinding) :
        RecyclerView.ViewHolder(view.root),
        LayoutContainer {
        override val containerView: View?
            get() = itemView

        fun bindItem(tv: A) {
            when (tv) {
                is AiringToday -> {
                    view.titleTv.text = tv.name
                    view.content.text =
                        if (tv.overview?.length!! > 80) tv.overview.substring(0, 80) + "..."
                        else tv.overview
                    view.releaseDate.text = DateUtils.humanDate(tv.first_air_date)
                    view.rating.text = tv.vote_average
                    Helpers.loadImage(view.imageView, tv.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(tv.id)
                        }
                    }
                }

                is OnTheAir -> {
                    view.titleTv.text = tv.name
                    view.content.text =
                        if (tv.overview?.length!! > 80) tv.overview.substring(0, 80) + "..."
                        else tv.overview
                    view.releaseDate.text = DateUtils.humanDate(tv.first_air_date)
                    view.rating.text = tv.vote_average
                    Helpers.loadImage(view.imageView, tv.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(tv.id)
                        }
                    }
                }

                is PopularTv -> {
                    view.titleTv.text = tv.name
                    view.content.text =
                        if (tv.overview?.length!! > 80) tv.overview.substring(0, 80) + "..."
                        else tv.overview
                    view.releaseDate.text = DateUtils.humanDate(tv.first_air_date)
                    view.rating.text = tv.vote_average
                    Helpers.loadImage(view.imageView, tv.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(tv.id)
                        }
                    }
                }

                is Tvshow -> {
                    view.titleTv.text = tv.name
                    view.content.text =
                        if (tv.overview?.length!! > 80) tv.overview.substring(0, 80) + "..."
                        else tv.overview
                    view.releaseDate.text = DateUtils.humanDate(tv.first_air_date)
                    view.rating.text = tv.vote_average
                    Helpers.loadImage(view.imageView, tv.poster_path)

                    containerView?.context.let {
                        containerView?.setOnClickListener {
                            onClick(tv.id)
                        }
                    }
                }
            }
        }
    }
}

private class TvShowCallback<A> : DiffUtil.ItemCallback<A>() {

    override fun areItemsTheSame(oldItem: A, newItem: A): Boolean {
        return if ((oldItem is AiringToday) && (newItem is AiringToday)) {
            oldItem.name == newItem.name
        } else if ((oldItem is OnTheAir) && (newItem is OnTheAir)) {
            oldItem.name == newItem.name
        } else if ((oldItem is PopularTv) && (newItem is PopularTv)) {
            oldItem.name == newItem.name
        } else {
            (oldItem as Tvshow).name == (newItem as Tvshow).name
        }
    }

    override fun areContentsTheSame(oldItem: A, newItem: A): Boolean {
        return if ((oldItem is AiringToday) && (newItem is AiringToday)) {
            (oldItem as AiringToday) == (newItem as AiringToday)
        } else if ((oldItem is OnTheAir) && (newItem is OnTheAir)) {
            (oldItem as OnTheAir) == (newItem as OnTheAir)
        } else if ((oldItem is PopularTv) && (newItem is PopularTv)) {
            (oldItem as PopularTv) == (newItem as PopularTv)
        } else {
            (oldItem as Tvshow) == (newItem as Tvshow)
        }
    }
}