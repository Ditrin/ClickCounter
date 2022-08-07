package com.example.clickcounter.domain.presenter

import com.example.clickcounter.domain.model.SettingsModel
import com.example.clickcounter.domain.view.SettingsView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class SettingsPresenter(
    private val model: SettingsModel,
    private val router: Router
) : MvpPresenter<SettingsView>() {

    fun setIncrement(value: String) {
        viewState.setIncrement(value.toInt())
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setIncrement(model.valueIncrement)
    }
}