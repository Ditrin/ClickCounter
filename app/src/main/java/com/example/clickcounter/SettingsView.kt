package com.example.clickcounter

import android.widget.EditText
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface SettingsView: MvpView {

    fun setIncrement(count: Int)

    class Base: SettingsView{

        private val countTextView: EditText? = null

        override fun setIncrement(count: Int) {
            countTextView?.setText(count)

        }

    }
}