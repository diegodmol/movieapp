# Retrofit / OkHttp / Gson
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.movieapp.data.remote.dto.** { *; }
-keep class com.movieapp.domain.model.** { *; }

-dontwarn okhttp3.**
-dontwarn retrofit2.**
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}
