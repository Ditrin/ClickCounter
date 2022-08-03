package com.example.clickcounter

import androidx.fragment.app.Fragment
import moxy.MvpFragment
import moxy.ktx.moxyPresenter

class CounterFragment : MvpFragment() {

    private val presenter by moxyPresenter {
        CounterPresenter.Base(
            CounterModel.Base(0, 1),
            CounterView.Base()
        )
    }

}