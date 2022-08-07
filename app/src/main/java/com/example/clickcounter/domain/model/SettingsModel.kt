package com.example.clickcounter.domain.model

interface SettingsModel {
    var valueIncrement: Int

    fun setValue(increment: String)

    class Base(override var valueIncrement: Int) : SettingsModel {

        override fun setValue(increment: String) {
            valueIncrement = increment.toInt()
        }
    }
}