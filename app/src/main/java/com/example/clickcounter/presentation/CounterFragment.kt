package com.example.clickcounter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.clickcounter.*
import com.example.clickcounter.databinding.CounterFragmentBinding
import com.example.clickcounter.domain.model.CounterModel
import com.example.clickcounter.domain.presenter.CounterPresenter
import com.example.clickcounter.domain.view.CounterView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class CounterFragment : MvpAppCompatFragment(R.layout.counter_fragment), CounterView {

    private val presenter by moxyPresenter {
        CounterPresenter(
            CounterModel.Base(0, ValueIncrement.value),
            App.INSTANCE.router
        )
    }

    lateinit var binding: CounterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CounterFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.counterEnter.setOnClickListener {
            presenter.onCountPressed()
            Toast.makeText(activity, getString(R.string.counter_improve), Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun setCount(count: String) {
        binding.counterState.text = count
    }

    override fun setInc(count: String) {
        binding.incrementState.text = count
    }

    override fun onCountButtonPressed(onClick: () -> Unit) {
        binding.counterEnter.setOnClickListener {
            onClick()
        }
    }
}