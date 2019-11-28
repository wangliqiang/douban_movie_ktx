package com.app.douban_movie_ktx.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.douban_movie_ktx.data.model.Subject
import com.app.douban_movie_ktx.databinding.ItemInTheatersRecyclerviewBinding

class InTheatersAdapter :
    ListAdapter<Subject, InTheatersAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemInTheatersRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.apply {
            bind(item)
            itemView.tag = item
        }
    }

    class ViewHolder(private val binding: ItemInTheatersRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subjectsBean: Subject?) {
            binding.apply {
                subject = subjectsBean
                executePendingBindings()
            }
        }
    }


    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Subject>() {
            override fun areItemsTheSame(oldItem: Subject, newItem: Subject): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Subject, newItem: Subject): Boolean =
                oldItem == newItem
        }
    }

}