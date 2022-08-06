package com.example.clickcounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.clickcounter.databinding.CounterFragmentBinding
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatFragment
import moxy.MvpFragment
import moxy.MvpView
import moxy.ktx.moxyPresenter
import javax.inject.Provider

class CounterFragment : MvpAppCompatFragment(R.layout.counter_fragment), CounterView {

    private val navigator = AppNavigator(FragmentActivity(), R.id.counterContainer)


//    lateinit var presenterProvider: Provider<CounterPresenter>

    private val presenter by moxyPresenter {
//        presenterProvider.get()
        CounterPresenter(CounterModel.Base(0, 1), CounterView.Base(), App.INSTANCE.router)
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
        }

//        binding.counterState.text =
//        App.INSTANCE.router.backTo(Screens.OptionScreen())


    }

    override fun setCount(count: String) {
        binding.counterState.text = count
    }

    override fun setInc(count: String) {
        binding.incrementState.text = count
    }

    override fun onCountButtonPressed(onClick: () -> Unit) {
        binding.counterEnter.setOnClickListener { onClick() }
    }


}