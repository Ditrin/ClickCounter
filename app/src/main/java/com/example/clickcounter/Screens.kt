package com.example.clickcounter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun OptionScreen() = FragmentScreen { OptionFragment() }
    fun CounterScreen() = FragmentScreen { CounterFragment() }
    fun SettingsScreen() = FragmentScreen { SettingsFragment() }
}
