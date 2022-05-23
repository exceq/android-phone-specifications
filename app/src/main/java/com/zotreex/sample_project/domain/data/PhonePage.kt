package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

data class PhonePage(
    @SerializedName("current_page")
    val currentPage: Int?,
    @SerializedName("last_page")
    val lastPage: Int?,
    @SerializedName("phones")
    val phones: List<Phone>,
    @SerializedName("title")
    val title: String
)