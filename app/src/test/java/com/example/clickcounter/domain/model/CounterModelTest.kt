package com.example.clickcounter.domain.model

import org.junit.Assert.*

import org.junit.Test

class CounterModelTest {

    @Test
    fun increment() {
        val checkIncrement = CounterModel.Base(0, 999)
        checkIncrement.increment()
        assertEquals(checkIncrement.data, 999)
    }
}