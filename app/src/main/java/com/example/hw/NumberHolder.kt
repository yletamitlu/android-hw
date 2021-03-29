package com.example.hw

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NumberHolder(itemView: View, private val clickListener: OnClickListener): RecyclerView.ViewHolder(itemView) {
    private val number: TextView = itemView.findViewById(R.id.number)
    private var numberValue: Int = 0

    init {
        number.setOnClickListener {
            clickListener.onNumberClick(numberValue)
        }
    }

    fun bind(value: Int) {
        number.text = value.toString()
        numberValue = value

        val color = if (value % 2 == 0)
            Color.RED
        else
            Color.BLUE

        number.setTextColor(color)
    }
}
