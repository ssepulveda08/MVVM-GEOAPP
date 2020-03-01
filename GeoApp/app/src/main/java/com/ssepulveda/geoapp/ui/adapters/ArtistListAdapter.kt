package com.ssepulveda.geoapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.ssepulveda.geoapp.R
import com.ssepulveda.geoapp.databinding.ItemPostBinding
import com.ssepulveda.geoapp.network.models.Artist
import com.ssepulveda.geoapp.viewModels.PostViewModel

class ArtistListAdapter : RecyclerView.Adapter<ArtistListAdapter.ViewHolder>() {

    private lateinit var postList: List<Artist>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_post,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postList[position])
    }

    override fun getItemCount(): Int {
        return if (::postList.isInitialized) postList.size else 0
    }

    fun updatePostList(postList: List<Artist>) {
        this.postList = postList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemPostBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = PostViewModel()
        fun bind(post: Artist) {
            viewModel.bind(post)
            binding.viewModel = viewModel
            binding.postTitle.text = post.name
        }
    }
}