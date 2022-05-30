package com.zotreex.sample_project.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.squareup.picasso.Picasso
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.FragmentPhoneSpecificationBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.Spec
import com.zotreex.sample_project.domain.data.Specification
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.ui.adapters.PhoneSpecificationListAdapter
import javax.inject.Inject

class PhoneSpecificationFragment : Fragment(R.layout.fragment_phone_specification) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<PhoneSpecificationViewModel> { viewModelFactory }
    private val binding: FragmentPhoneSpecificationBinding by viewBinding()
    private val adapter = PhoneSpecificationListAdapter()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val slug = arguments?.getString("slug")
        viewModel.getPhoneSpecification(slug)

        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recycler.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner) {
            it ?: return@observe
            if (it is UiState.Loading)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE

            if (it is UiState.Success) {
                binding.brand.text = it.value.brand
                binding.phoneName.text = it.value.phoneName
                Picasso.get().load(it.value.phoneImages.get(0)).into(binding.image)

                val specification = Specification(
                    mutableListOf(
                        Spec("dimension", mutableListOf(it.value.dimension)),
                        Spec("os", mutableListOf(it.value.os)),
                        Spec("releaseDate", mutableListOf(it.value.releaseDate)),
                        Spec("storage", mutableListOf(it.value.storage))
                    ), "Specification"
                )
                adapter.submitList(mutableListOf(specification) + it.value.specifications)
            }

            if (it is UiState.Error) {
                binding.brand.text = it.msg
            }
        }
    }

}