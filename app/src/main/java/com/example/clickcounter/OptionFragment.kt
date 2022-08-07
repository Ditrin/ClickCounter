package com.example.clickcounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.clickcounter.databinding.CounterFragmentBinding
import com.example.clickcounter.databinding.OptionsFragmentBinding
import moxy.MvpAppCompatFragment
import moxy.MvpFragment
import moxy.ktx.moxyPresenter

class OptionFragment : MvpAppCompatFragment(R.layout.options_fragment), BackButtonListener, OptionView {

    private lateinit var binding: OptionsFragmentBinding

    private val presenter by moxyPresenter {
        OptionPresenter(App.INSTANCE.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = OptionsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settingsButton.setOnClickListener {
            App.INSTANCE.router.navigateTo(Screens.SettingsScreen())
        }

        binding.counterButton.setOnClickListener {
            App.INSTANCE.router.navigateTo(Screens.CounterScreen())
        }
    }

    override fun backPressed(): Boolean = presenter.onBackPressed()


}