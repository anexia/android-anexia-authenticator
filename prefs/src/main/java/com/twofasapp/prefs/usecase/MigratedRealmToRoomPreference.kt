package com.twofasapp.prefs.usecase

import com.twofasapp.prefs.internals.PreferenceBoolean
import com.twofasapp.storage.Preferences

class MigratedRealmToRoomPreference(preferences: Preferences) : PreferenceBoolean(preferences) {
    override val key: String = "migratedRealmToRoom"
}