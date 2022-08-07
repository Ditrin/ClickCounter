package com.example.clickcounter.domain.presenter

import com.example.clickcounter.domain.view.MainView
import com.example.clickcounter.Screens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter(private val router: Router) :
    MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.OptionScreen())
    }

    fun backClicked() {
        router.exit()
    }
}