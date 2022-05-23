package com.zotreex.sample_project.di

import android.content.Context
import com.zotreex.sample_project.MainApplication

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApplication -> appComponent
        else -> applicationContext.appComponent
    }
