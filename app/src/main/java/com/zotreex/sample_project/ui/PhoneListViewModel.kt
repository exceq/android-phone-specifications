package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.Phone
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.repository.SpecificationRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class PhoneListViewModel @Inject constructor(
    private val specificationRepository: SpecificationRepository
) : ViewModel() {
    val liveData = MutableLiveData<UiState<List<Phone>>>(UiState.Loading)
    val liveDateSearch = MutableLiveData<UiState<List<Phone>>>()

    fun getLatest() {
        viewModelScope.launch {
            val response = specificationRepository.getLatest()
            if (response.status)
                liveData.postValue(UiState.Success(response.data.phones))
            else
                liveData.postValue(UiState.Error("Не удалось получить новинки"))
        }
    }

    fun search(query: String) {
        viewModelScope.launch {
            liveDateSearch.postValue(UiState.Loading)

            val searchResult = specificationRepository.getSearchResult(query)

            if (searchResult.status)
                liveDateSearch.postValue(UiState.Success(searchResult.data.phones))
            else
                liveDateSearch.postValue(UiState.Error("Не удалось получить данные по запросу '$query'"))
        }
    }
}