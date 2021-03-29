package com.example.hw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class NumberAdapter(private val data: List<Int>, private var listener: OnClickListener): RecyclerView.Adapter<NumberHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.number, parent, false)
        return NumberHolder(view, listener)
    }

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
