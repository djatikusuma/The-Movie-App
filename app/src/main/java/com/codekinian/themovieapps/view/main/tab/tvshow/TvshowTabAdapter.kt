package com.codekinian.themovieapps.view.main.tab.tvshow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codekinian.themovieapps.databinding.TvshowItemBinding
import com.codekinian.themovieapps.model.data.Tvshow
import kotlinx.android.extensions.LayoutContainer

class TvshowTabAdapter(
    private val onClick: (Int) -> Unit
) : RecyclerView.Adapter<TvshowTabAdapter.ViewHolder>() {
    private val tvshows = ArrayList<Tvshow>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        TvshowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount(): Int = tvshows.size

    fun updateData(newList: List<Tvshow>?) {
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

        fun bindItem(tv: Tvshow) {
            view.tv = tv

            containerView?.context.let {
                containerView?.setOnClickListener {
                    onClick(tv.id)
                }
            }
        }
    }
}