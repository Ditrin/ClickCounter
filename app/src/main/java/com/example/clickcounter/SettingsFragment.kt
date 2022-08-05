package com.example.clickcounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.clickcounter.databinding.SettingsFragmentBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SettingsFragment: MvpAppCompatFragment(R.layout.settings_fragment), SettingsView {
    private lateinit var binding: SettingsFragmentBinding

    private val presenter by moxyPresenter {
//        presenterProvider.get()
        SettingsPresenter(SettingsModel.Base(1), SettingsView.Base(), App.INSTANCE.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SettingsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.incrementEnter.setOnClickListener { edittext->
            presenter.setIncrement(binding.incrementEnter.text.toString())
            val bundle = Bundle().apply {
                putSerializable("increment", binding.incrementEnter.text.toString())
            }
            binding.incrementEnter.text
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

    }

    override fun setIncrement(count: Int) {
        binding.incrementEnter.setText(count.toString())
    }

}