import org.bouncycastle.cms.RecipientId.password

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.maven.publish)
}

android {
    namespace = "com.jalaljankhan.pm"
    compileSdk = 35

    defaultConfig {
        minSdk = 23

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

afterEvaluate {
    android.libraryVariants.forEach { variant ->
        publishing.publications.create(variant.name, MavenPublication::class.java) {
            from(components.findByName(variant.name))

            groupId = "com.jalaljankhan.pm"
            artifactId = "pm"
            version = "1.0.0"
        }
    }
}

//val dotenv = io.github.cdimascio.dotenv.Dotenv.load()

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/jalaljankhaan/PermissionManager")
            credentials {
                // Only set username if the environment variable is present
                username = System.getenv("GITHUB_USERNAME") ?: "jalaljankhaan"
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}