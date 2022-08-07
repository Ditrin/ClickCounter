package com.example.clickcounter.domain.presenter

import com.example.clickcounter.domain.view.CounterView
import com.example.clickcounter.domain.model.CounterModel
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class CounterPresenter(
    private val model: CounterModel,
    private val router: Router
) : MvpPresenter<CounterView>() {

    fun onCountPressed() {
        model.increment()
        viewState.setCount(model.data.toString())
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setCount(model.data.toString())
        viewState.setInc(model.valueIncrement.toString())
    }
}


