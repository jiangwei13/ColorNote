# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# === Android/Google 系 ===
-keep class androidx.** {*;}
-keep class com.google.** {*;}
-keep class com.android.** {*;}
# === 广告聚合平台 ===
-keep class com.tradplusad.** {*;}
-keep class com.thinkup.** {*;}
-keep class com.smartdigimkttech.** {*;}
# === 广告网络 SDK ===
-keep class com.facebook.** {*;}
-keep class com.applovin.** {*;}
-keep class com.unity3d.** {*;}
-keep class com.ironsource.** {*;}
-keep class com.chartboost.** {*;}
-keep class com.mbridge.** {*;}
-keep class com.pangle.** {*;}
-keep class com.bigossp.** {*;}
-keep class com.vungle.** {*;}
-keep class com.inmobi.** {*;}
-keep class com.fyber.** {*;}
-keep class com.mi.** {*;}
-keep class io.github.kwainetwork.** {*;}
# === 归因/分析 ===
-keep class com.adjust.** {*;}
-keep class com.appsflyer.** {*;}
-keep class com.tencent.** {*;}
# === 华为/荣耀 ===
-keep class com.huawei.** {*;}
-keep class com.hihonor.** {*;}
-keep class com.miui.** {*;}
# === 基础网络/工具库 ===
-keep class com.squareup.** {*;}
-keep class com.jakewharton.** {*;}
-keep class com.github.** {*;}
-keep class org.greenrobot.** {*;}
-keep class io.reactivex.** {*;}
-keep class org.jetbrains.** {*;}
-keep class kotlin.** {*;}
-keep class com.meituan.** {*;}
