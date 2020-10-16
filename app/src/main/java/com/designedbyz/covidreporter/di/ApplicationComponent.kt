package com.designedbyz.covidreporter.di

import android.app.Application
import com.designedbyz.covidreporter.MainActivity
import dagger.BindsInstance
import dagger.Component

//generic dagger. I have not yet had time to explore hilt.
@ApplicationScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        fun build() : ApplicationComponent

        @BindsInstance
        fun application(application: Application): Builder
    }

    fun injectInto(mainActivity: MainActivity) //a more readable twist on the standard "inject" method
}
