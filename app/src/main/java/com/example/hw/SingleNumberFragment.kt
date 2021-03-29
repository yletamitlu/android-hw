package com.example.hw

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class SingleNumberFragment: Fragment() {
    private var value: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        value = arguments?.getInt(Consts.LABEL_VALUE, 0) ?: 0
    }

    override fun onCreateView (
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_single_number, container, false)
        val textView = view.findViewById<TextView>(R.id.single_number)
        if (savedInstanceState != null) {
            value = savedInstanceState.getInt(Consts.LABEL_NUMBER)
        }
        textView.text = value.toString()
        val color = if (value % 2 == 0)
            Color.RED
        else
            Color.BLUE

        textView.setTextColor(color)
        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Consts.LABEL_NUMBER, value)
    }
}
