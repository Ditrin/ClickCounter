package com.example.clickcounter

interface CounterModel {
    var data: Int
    var valueIncrement: Int

    fun increment()

    class Base(override var data: Int, override var valueIncrement: Int): CounterModel{
        override fun increment() {
            data += valueIncrement
        }
    }
}