package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.SampleItem
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.usecases.getSampleList.GetSampleListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class SampleViewModel @Inject constructor(
    private val getSampleListUseCase: GetSampleListUseCase
) : ViewModel() {
    val liveData = MutableLiveData<UiState<List<SampleItem>>>(UiState.Loading)

    init {
        viewModelScope.launch {
            val list = getSampleListUseCase()
            liveData.postValue(UiState.Success(list))
        }
    }

    fun setLive() {
        val list = listOf(
            SampleItem(id = 1, title = "test1"),
            SampleItem(id = 2, title = "test2")
        )
        liveData.postValue(UiState.Success(list))
    }
}