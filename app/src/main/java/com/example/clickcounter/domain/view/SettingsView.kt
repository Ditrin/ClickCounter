package com.example.clickcounter.domain.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface SettingsView : MvpView {

    fun setIncrement(count: Int)
}