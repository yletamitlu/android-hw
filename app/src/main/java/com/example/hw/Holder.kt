package com.example.hw

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val number: TextView = itemView.findViewById(R.id.number)

    fun bind(value: Int) {
        number.text = value.toString()

        val color = if (value % 2 == 0)
            Color.BLUE
        else
            Color.RED

        number.setTextColor(color)
    }

}