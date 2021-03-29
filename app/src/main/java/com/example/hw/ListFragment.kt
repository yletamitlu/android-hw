package com.example.hw

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


interface OnClickListener {
    fun onNumberClick(number: Int)
}


class ListFragment: Fragment(), OnClickListener {
    private var amount: Int = Consts.AMOUNT

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val columnCount: Int = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            Consts.PORTRAIT_COLUMNS
        else
            Consts.LANDSCAPE_COLUMNS

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.setItemViewCacheSize(Consts.CACHE_SIZE)
        recycler.layoutManager = GridLayoutManager(this.context, columnCount)

        restoreState(savedInstanceState)

        val data: MutableList<Int> = mutableListOf()
        for (i in 0..amount) {
            data.add(i)
        }
        val adapter = NumberAdapter(data, this)
        recycler.adapter = adapter

        val btn = view.findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            data.add(data.size)
            adapter.notifyItemInserted(data.size - 1)
            amount = data.size - 1
        }

        return view
    }

    private fun restoreState(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            amount = savedInstanceState.getInt(Consts.LABEL_AMOUNT)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Consts.LABEL_AMOUNT, amount)
    }

    override fun onNumberClick(number: Int) {
        val args = Bundle()
        args.putInt(Consts.LABEL_VALUE, number)

        val singleNum = SingleNumberFragment()
        singleNum.arguments = args;

        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.wrapper, singleNum)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }
}
