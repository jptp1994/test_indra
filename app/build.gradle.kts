plugins {
    id("com.android.application")
}

android {
    namespace = "com.test.indra"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.test.indra"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    //Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.9.0")

    //Rx Java
    implementation("io.reactivex:rxandroid:1.2.0")
    implementation("io.reactivex:rxjava:1.1.8")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.3.0")



    //UI
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.appcompat:appcompat:1.6.1")

    //Material
    implementation("com.google.android.material:material:1.10.0")

    //Unit testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Picasso
    implementation("com.squareup.picasso:picasso:2.8")



}