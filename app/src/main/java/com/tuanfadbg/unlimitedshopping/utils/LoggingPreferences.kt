package com.tuanfadbg.unlimitedshopping.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggingPreferences @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    var isLoggingEnabled: Boolean
        get() = prefs.getBoolean(KEY_LOGGING_ENABLED, false)
        set(value) = prefs.edit().putBoolean(KEY_LOGGING_ENABLED, value).apply()

    companion object {
        private const val PREFS_NAME = "logging_preferences"
        private const val KEY_LOGGING_ENABLED = "is_logging_enabled"
    }
} 