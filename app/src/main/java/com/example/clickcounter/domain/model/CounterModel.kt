package com.example.clickcounter.domain.model

interface CounterModel {
    var data: Int
    var valueIncrement: Int

    fun increment()

    class Base(override var data: Int, override var valueIncrement: Int): CounterModel {
        override fun increment() {
            data += valueIncrement
        }
    }
}