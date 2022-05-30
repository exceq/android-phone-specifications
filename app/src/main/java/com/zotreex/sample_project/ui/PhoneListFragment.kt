package com.zotreex.sample_project.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.zotreex.sample_project.R
import com.zotreex.sample_project.databinding.FragmentPhoneListBinding
import com.zotreex.sample_project.di.ViewModelFactory
import com.zotreex.sample_project.di.appComponent
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.ui.adapters.PhoneListAdapter
import javax.inject.Inject

class PhoneListFragment : Fragment(R.layout.fragment_phone_list) {
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<PhoneListViewModel> { viewModelFactory }
    private val viewModelSpec by viewModels<PhoneSpecificationViewModel> { viewModelFactory }
    private val binding: FragmentPhoneListBinding by viewBinding()
    private val adapter = PhoneListAdapter()

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.VERTICAL
            )
        )
        binding.recycler.adapter = adapter

        adapter.onItemClick = { phone ->
            Navigation.findNavController(view)
                .navigate(
                    R.id.action_phoneListFragment_to_phoneSpecificationFragment,
                    bundleOf(Pair("slug", phone.slug))
                )
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            it ?: return@observe
            if (it is UiState.Loading)
                binding.progress.visibility = View.VISIBLE
            else
                binding.progress.visibility = View.GONE

            if (it is UiState.Success)
                adapter.submitList(it.value)

        }
    }
}