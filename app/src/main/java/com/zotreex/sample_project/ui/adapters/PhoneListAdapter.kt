package com.zotreex.sample_project.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zotreex.sample_project.databinding.PhoneListItemBinding
import com.zotreex.sample_project.domain.data.Phone

class PhoneListAdapter :
    ListAdapter<Phone, PhoneListAdapter.ViewHolder>(SampleDiffCallBack()) {

    var onItemClick: ((Phone) -> Unit)? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sampleItem: Phone = currentList[position]
        holder.bind(sampleItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PhoneListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    inner class ViewHolder(private val binding: PhoneListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(currentList[adapterPosition])
            }
        }

        fun bind(item: Phone) {
            binding.phoneName.text = item.phoneName
            binding.brand.text = item.brand
            Picasso.get().load(item.image).into(binding.phoneImage)
        }
    }
}

class SampleDiffCallBack : DiffUtil.ItemCallback<Phone>() {
    override fun areItemsTheSame(oldItem: Phone, newItem: Phone): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: Phone, newItem: Phone): Boolean =
        oldItem == newItem

}

