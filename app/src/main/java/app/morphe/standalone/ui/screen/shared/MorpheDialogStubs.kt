package app.morphe.standalone.ui.screen.shared

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.Dialog

val LocalDialogTextColor = compositionLocalOf { Color.Black }
val LocalDialogSecondaryTextColor = compositionLocalOf { Color.Gray }

@Composable
fun MorpheDialog(
    onDismissRequest: () -> Unit,
    title: String? = null,
    noPadding: Boolean = false,
    scrollable: Boolean = false,
    footer: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(shape = MaterialTheme.shapes.large, color = MaterialTheme.colorScheme.surface) {
            CompositionLocalProvider(
                LocalDialogTextColor provides MaterialTheme.colorScheme.onSurface,
                LocalDialogSecondaryTextColor provides MaterialTheme.colorScheme.onSurfaceVariant
            ) {
                content()
            }
        }
    }
}

@Composable
fun MorpheDialogButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    Button(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}

@Composable
fun MorpheDialogOutlinedButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
    modifier: Modifier = Modifier
) {
    OutlinedButton(onClick = onClick, enabled = enabled, modifier = modifier) {
        Text(text)
    }
}
