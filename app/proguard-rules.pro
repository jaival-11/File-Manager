# ProGuard / R8 rules for Simple File Manager
#
# R8 automatically loads consumer rules from dependencies (e.g. Koin, Coil, libsu, aboutlibraries).
# Add any application-specific keep rules here if needed.

# Keep Compose-specific layouts and previews
-keepclassmembers class * {
    @androidx.compose.runtime.Composable *;
}

# Keep AboutLibraries data models to prevent deserialization issues
-keep class com.mikepenz.aboutlibraries.** { *; }

# Keep Kotlin reflect / metadata if needed for reflection-heavy libraries
-keep class kotlin.Metadata { *; }
