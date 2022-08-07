package com.example.clickcounter.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.example.clickcounter.*
import com.example.clickcounter.databinding.SettingsFragmentBinding
import com.example.clickcounter.domain.model.SettingsModel
import com.example.clickcounter.domain.presenter.SettingsPresenter
import com.example.clickcounter.domain.view.SettingsView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class SettingsFragment : MvpAppCompatFragment(R.layout.settings_fragment), SettingsView {
    private lateinit var binding: SettingsFragmentBinding

    private val presenter by moxyPresenter {
        SettingsPresenter(SettingsModel.Base(ValueIncrement.value), App.INSTANCE.router)
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

        binding.incrementEnter.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                try {
                    presenter.setIncrement(binding.incrementEnter.text.toString())
                    ValueIncrement.value = binding.incrementEnter.text.toString().toInt()
                } catch (e: Exception) {
                    Toast.makeText(activity, "invalid number", Toast.LENGTH_SHORT).show()
                } finally {
                    true
                }
            }
            false
        }
    }

    override fun setIncrement(count: Int) {
        binding.incrementEnter.setText(count.toString())
    }
}