package com.example.appmarsphotos

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Tạo ra một ứng dụng Hilt để cung cấp các dependencies cho toàn bộ ứng dụng
@HiltAndroidApp
class BaseApplication : Application() {
}