package com.example.clickcounter

import moxy.MvpPresenter
import moxy.MvpView

interface CounterPresenter  {
    fun onCountPressed()

    class Base(private val model: CounterModel, private val view: CounterView): CounterPresenter, MvpPresenter<MvpView>(){ //базовая реализация интерфейса

        init {
            view.setInc(model.valueIncrement.toString())
        }

        override fun onCountPressed() {
            model.increment()
            view.setCount(model.data.toString())
        }
    }
}