package me.jaival.files.domain.manager

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class PreferencesManager(context: Context) {
    private val prefs = context.getSharedPreferences("monet_files_prefs", Context.MODE_PRIVATE)
    
    val filePickerSortMode = PersistentPref("NAME_ASC", "sort_mode")
    val lastFilePickerPath = PersistentPref("", "last_path")
    val useCustomFilePicker = PersistentPref(true, "custom_picker")

    inner class PersistentPref<T>(private val default: T, private val key: String) {
        fun get(): T {
            return when (default) {
                is String -> prefs.getString(key, default) as T
                is Boolean -> prefs.getBoolean(key, default) as T
                else -> default
            }
        }
        fun getBlocking() = get()
        fun update(v: T) {
            when (v) {
                is String -> prefs.edit().putString(key, v).apply()
                is Boolean -> prefs.edit().putBoolean(key, v).apply()
            }
        }
        fun getAsState(): State<T> = mutableStateOf(get())
    }
}
