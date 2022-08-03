package com.example.clickcounter

import com.github.terrakok.cicerone.Router

class SamplePresenter(
    private val router: Router
) : Presenter<SampleView>() {

    fun onOpenNewScreen() {
        router.navigateTo(SomeScreen())
    }

    fun onBackPressed() {
        router.exit()
    }
}