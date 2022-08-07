package com.example.clickcounter.domain.presenter

import com.example.clickcounter.domain.view.OptionView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class OptionPresenter(private val router: Router) : MvpPresenter<OptionView>() {
    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}