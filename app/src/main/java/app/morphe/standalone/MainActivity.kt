package app.morphe.standalone

import android.app.Application
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import app.morphe.standalone.data.platform.Filesystem
import app.morphe.standalone.domain.manager.PreferencesManager
import app.morphe.standalone.ui.screen.shared.FilePicker
import app.morphe.standalone.util.PM
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

val appModule = module {
    single { PreferencesManager() }
    single { PM(get()) }
    single { Filesystem(get<android.content.Context>() as Application) }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Initialize Koin dependencies
        if (org.koin.core.context.GlobalContext.getOrNull() == null) {
            startKoin {
                androidContext(this@MainActivity.applicationContext)
                modules(appModule)
            }
        }

        setContent {
            MaterialTheme {
                Surface {
                    FilePicker(
                        mimeTypes = arrayOf("*/*"),
                        onDismiss = { 
                            // Close the app when the back/cancel button is hit
                            finish() 
                        },
                        onFilePicked = { file ->
                            // Show a toast with the selected file name
                            Toast.makeText(this@MainActivity, "Picked: ${file.name}", Toast.LENGTH_LONG).show()
                        },
                        allowFolderSelection = false
                    )
                }
            }
        }
    }
}
