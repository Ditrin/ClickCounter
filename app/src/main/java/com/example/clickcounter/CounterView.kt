package com.example.clickcounter

import android.widget.Button
import android.widget.TextView

interface CounterView {
    fun setCount(count: String)
    fun setInc(count: String)
    fun onCountButtonPressed(onClick: () -> Unit)

    class Base() : CounterView {

        private val countTextView: TextView? = null
        private val incrementTextView: TextView? = null
        private val button: Button? = null

        override fun setCount(count: String) {
            countTextView?.text = count
        }

        override fun setInc(count: String) {
            incrementTextView?.text = count
        }

        override fun onCountButtonPressed(onClick: () -> Unit) {
            button?.setOnClickListener { onClick() }
        }
    }
}