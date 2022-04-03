package com.example.moviesapp.presentation.ui.movie

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.moviesapp.databinding.ItemMovieBinding
import com.example.moviesapp.domain.model.Movie

class MovieAdapter(
    private val listOnItemClick: OnItemClick
): ListAdapter<Movie, MovieAdapter.ViewHolder>(PhotoDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.apply {
                ivImImage.load(URL + item.posterPath)
                tvImTittle.text = item.title
                rbImVoteAverage.rating = item.voteAverage!!.toFloat()
                root.setOnClickListener {
                    listOnItemClick.onClick(item)
                }
            }
        }
    }
}

interface OnItemClick {
    fun onClick(item: Movie)
}

private class PhotoDiffCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.id == newItem.id
}

const val URL = "https://image.tmdb.org/t/p/w500/"