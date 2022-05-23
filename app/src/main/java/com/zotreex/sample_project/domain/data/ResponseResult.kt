package com.zotreex.sample_project.domain.data

import com.google.gson.annotations.SerializedName

open class ResponseResult<T>(
    @SerializedName("data")
    open val data: T,
    @SerializedName("status")
    open val status: Boolean
)