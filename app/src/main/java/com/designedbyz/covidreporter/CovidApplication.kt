package com.designedbyz.covidreporter

import android.app.Application
import com.designedbyz.covidreporter.di.DaggerApplicationComponent

class CovidApplication: Application() {
    val applicationComponent = DaggerApplicationComponent.builder().application(this).build()
}
