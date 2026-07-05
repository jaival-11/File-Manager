package app.morphe.standalone

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import app.morphe.standalone.data.platform.Filesystem
import app.morphe.standalone.domain.manager.PreferencesManager
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
        
        if (org.koin.core.context.GlobalContext.getOrNull() == null) {
            startKoin {
                androidContext(this@MainActivity.applicationContext)
                modules(appModule)
            }
        }

        setContent {
            // The file picker is ready to be mounted here once the build passes
        }
    }
}
