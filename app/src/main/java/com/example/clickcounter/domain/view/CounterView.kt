package com.example.clickcounter.domain.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface CounterView : MvpView {
    fun setCount(count: String)
    fun setInc(count: String)
    fun onCountButtonPressed(onClick: () -> Unit)
}