package me.jaival.files.domain.manager

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class PreferencesManager {
    val filePickerSortMode = DummyPref("NAME_ASC")
    val lastFilePickerPath = DummyPref("")
    val useCustomFilePicker = DummyPref(true)

    class DummyPref<T>(private val default: T) {
        private var value = default
        fun get() = value
        fun getBlocking() = value
        fun update(v: T) { value = v }
        fun getAsState(): State<T> = mutableStateOf(value)
    }
}
