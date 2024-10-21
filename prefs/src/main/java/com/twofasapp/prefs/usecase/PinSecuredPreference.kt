package com.twofasapp.prefs.usecase

import android.content.Context
import com.twofasapp.prefs.internals.PreferenceString
import com.twofasapp.storage.Preferences
import de.adorsys.android.securestoragelibrary.SecurePreferences

// Historically it was only saved in SecurePreferences, migrate at some point
class PinSecuredPreference(
    private val context: Context,
    preferences: Preferences
) : PreferenceString(preferences) {

    override val key: String = "pinSecured"
    override val default: String = ""

    override fun get(): String {
        return SecurePreferences.getStringValue(key, context, default) ?: default
    }

    override fun put(model: String) {
        if (model.isBlank()) {
            SecurePreferences.removeValue(key, context)
        } else {
            SecurePreferences.setValue(key, model, context)
        }
    }
}