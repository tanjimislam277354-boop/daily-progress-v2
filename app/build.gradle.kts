plugins {
    id("com.android.application")
}
android {
    namespace = "com.tanjim.dailyprogress"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.tanjim.dailyprogress"
        minSdk = 19
        targetSdk = 34
        versionCode = 2
        versionName = "1.1"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation("androidx.appcompat:appcompat:1.6.1")
}
