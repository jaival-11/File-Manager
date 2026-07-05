package app.morphe.standalone.ui.screen.shared

import android.content.pm.PackageInfo
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppIcon(
    packageInfo: PackageInfo,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Icon(Icons.Outlined.Android, contentDescription = contentDescription)
    }
}
