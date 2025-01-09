package com.hb.daggersampleapp.di

import com.hb.daggersampleapp.MainActivity
import dagger.Component

@Component
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}