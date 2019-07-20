#Kotlinx serializer
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.SerializationKt
-keep,includedescriptorclasses class dk.youtec.**$$serializer { *; }
-keepclassmembers class dk.youtec.** {
    *** Companion;
}
-keepclasseswithmembers class dk.youtec.** { # <-- change package name to your app's
    kotlinx.serialization.KSerializer serializer(...);
}