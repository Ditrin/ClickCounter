package com.example.clickcounter

import com.example.clickcounter.presentation.CounterFragment
import com.example.clickcounter.presentation.OptionFragment
import com.example.clickcounter.presentation.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun OptionScreen() = FragmentScreen { OptionFragment() }
    fun CounterScreen() = FragmentScreen { CounterFragment() }
    fun SettingsScreen() = FragmentScreen { SettingsFragment() }
}
