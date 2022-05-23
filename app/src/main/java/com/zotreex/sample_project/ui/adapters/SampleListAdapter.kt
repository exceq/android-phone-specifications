package com.zotreex.sample_project.ui.adapters

import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zotreex.sample_project.databinding.SampleItemBinding
import com.zotreex.sample_project.domain.data.SampleItem

class SampleListAdapter() :
    ListAdapter<SampleItem, SampleListAdapter.ViewHolder>(SampleDiffCallBack()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sampleItem: SampleItem = currentList[position]
        holder.bind(sampleItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: SampleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SampleItem) {
            binding.text.text = item.title
        }
    }

}

class SampleDiffCallBack : DiffUtil.ItemCallback<SampleItem>() {
    override fun areItemsTheSame(oldItem: SampleItem, newItem: SampleItem): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: SampleItem, newItem: SampleItem): Boolean =
        oldItem == newItem

}

