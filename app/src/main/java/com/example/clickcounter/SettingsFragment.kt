package com.example.clickcounter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null){
            binding.incrementEnter.setText(savedInstanceState.getString("increment"))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



//        binding.incrementEnter.setOnEditorActionListener {
//            presenter.setIncrement(binding.incrementEnter.text.toString())
//            val bundle = Bundle().apply {
//                putSerializable("increment", binding.incrementEnter.text.toString())
//            }
//            savedInstanceState?.putAll(bundle)
//            binding.incrementEnter.text
//        }
        binding.incrementEnter.setOnEditorActionListener(TextView.OnEditorActionListener{ _, actionId, _ ->

            if (actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.setIncrement(binding.incrementEnter.text.toString())
                val bundle = Bundle().apply {
                    putSerializable("increment", binding.incrementEnter.text.toString())
                }
                savedInstanceState?.putString("increment", binding.incrementEnter.text.toString())
                // Do something of your interest.
                // We in this examples created the following Toasts


                return@OnEditorActionListener true
            }
            false
        })
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("increment", binding.incrementEnter.text.toString())

    }

    override fun setIncrement(count: Int) {
        binding.incrementEnter.setText(count.toString())
    }

}