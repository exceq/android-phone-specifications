package com.zotreex.sample_project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zotreex.sample_project.domain.data.PhoneSpecification
import com.zotreex.sample_project.domain.data.UiState
import com.zotreex.sample_project.domain.repository.SpecificationRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

class PhoneSpecificationViewModel @Inject constructor(
    private val specificationRepository: SpecificationRepository
) : ViewModel() {
    val liveData = MutableLiveData<UiState<PhoneSpecification>>(UiState.Loading)

    fun getPhoneSpecification(phone_slug: String?) {
        viewModelScope.launch {
            try {
                if (phone_slug == null)
                    liveData.postValue(UiState.Error("fail to fetch phone specification. No slug"))

                val response =
                    specificationRepository.getPhoneSpecification(phone_slug ?: "")
                if (response.status)
                    liveData.postValue(UiState.Success(response.data))
                else
                    liveData.postValue(UiState.Error("fail to fetch phone specification"))
            } catch (e: HttpException) {
                liveData.postValue(UiState.Error("Ошибка получения данных. Код: ${e.code()}. Сообщение: ${e.message()}"))
            }
        }
    }
}