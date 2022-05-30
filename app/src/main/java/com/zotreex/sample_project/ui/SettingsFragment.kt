package com.zotreex.sample_project.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.zotreex.sample_project.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}