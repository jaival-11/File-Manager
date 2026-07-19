package me.jaival.files.ui.screen.shared

import android.content.Context
import android.content.res.Configuration
import android.os.Environment
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import java.io.File

val ContentPadding = 16.dp
val ItemSpacing = 8.dp
val dialogEnter = fadeIn(tween(300)) + scaleIn(initialScale = 0.9f)
val dialogExit = fadeOut(tween(200)) + scaleOut(targetScale = 0.9f)
val overlayEnter = fadeIn(tween(300))
val overlayExit = fadeOut(tween(200))

object SimpleFileManagerDefaults {
    const val ANIMATION_DURATION = 300
}

object SimpleFileManagerAnimations {
    fun <T> fadeCrossfade() = fadeIn(tween(300)) togetherWith fadeOut(tween(300))
    val expandFadeEnter = fadeIn() + expandVertically()
    val shrinkFadeExit = fadeOut() + shrinkVertically()
}

@Composable
fun EmptyState(
    message: String,
    icon: ImageVector,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null
) {
    Box { Text(text = message) }
}

@Composable
fun isLandscape() = LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

fun Context.externalStorageVolumes(): List<Pair<Boolean, File>> {
    return listOf(true to Environment.getExternalStorageDirectory())
}
