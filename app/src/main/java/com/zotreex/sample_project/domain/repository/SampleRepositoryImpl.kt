package com.zotreex.sample_project.domain.repository

import com.zotreex.sample_project.domain.api.SampleService
import com.zotreex.sample_project.domain.data.SampleItem
import kotlinx.coroutines.delay
import javax.inject.Inject

class SampleRepositoryImpl @Inject constructor(
    private val sampleService: SampleService
) : SampleRepository {
    override suspend fun getSampleList(): List<SampleItem> {
        delay(3000)
        return listOf(
            SampleItem(id = 1, title = "test1"),
            SampleItem(id = 2, title = "test2")
        )
    }

    override suspend fun getSampleItem(id: Int): SampleItem = sampleService.getSampleItem(id)
}