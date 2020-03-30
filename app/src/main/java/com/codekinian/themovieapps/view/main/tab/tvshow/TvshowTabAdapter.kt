package com.codekinian.themovieapps.view.main.tab.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
) : RecyclerView.Adapter<TvshowTabAdapter<A>.ViewHolder>() {
    private val tvshows = ArrayList<A>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        TvshowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = tvshows.size

    fun updateData(newList: List<A>?) {
        if (newList == null) return
        tvshows.clear()
        tvshows.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(tvshows[position])
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