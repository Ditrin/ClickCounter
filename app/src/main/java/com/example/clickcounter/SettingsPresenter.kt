package com.example.clickcounter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class SettingsPresenter(private val model: SettingsModel, private val view: SettingsView, private val router: Router) : MvpPresenter<SettingsView>(){


    fun setIncrement(value : String){
        viewState.setIncrement(value.toInt())
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setIncrement(model.valueIncrement)
            }
}