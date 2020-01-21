package com.vitorota.bookseeker.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.vitorota.bookseeker.R
import kotlinx.android.synthetic.main.fragment_generic.view.*

abstract class GenericFragment : Fragment(R.layout.fragment_generic) {

    abstract fun getTitle(): Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(view) {
            tvTitle.setText(getTitle())
        }
    }
}