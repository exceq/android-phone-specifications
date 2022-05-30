package com.zotreex.sample_project.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zotreex.sample_project.databinding.SpecificationItemBinding
import com.zotreex.sample_project.domain.data.Specification

class PhoneSpecificationListAdapter :
    ListAdapter<Specification, PhoneSpecificationListAdapter.ViewHolder>(
        PhoneSpecificationDiffCallBack()
    ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sampleItem: Specification = currentList[position]
        holder.bind(sampleItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SpecificationItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    class ViewHolder(private val binding: SpecificationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Specification) {
            binding.title.text = item.title

            val str: String = item.specs.joinToString(separator = "\n\n") { spec ->
                "${spec.key}: ${spec.value.joinToString(separator = ", ")}"
            }
            binding.specs.text = str
        }
    }
}

class PhoneSpecificationDiffCallBack : DiffUtil.ItemCallback<Specification>() {
    override fun areItemsTheSame(oldItem: Specification, newItem: Specification): Boolean =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: Specification, newItem: Specification): Boolean =
        oldItem == newItem

}

