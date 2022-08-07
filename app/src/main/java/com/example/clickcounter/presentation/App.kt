package com.example.clickcounter.presentation

import android.annotation.SuppressLint
import android.app.Application
import com.github.terrakok.cicerone.Cicerone

@SuppressLint("Registered")
class App : Application() {
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        internal lateinit var INSTANCE: App
            private set
    }
}