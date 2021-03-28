package com.example.hw

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class List: Fragment() {
    var amount: Int = Consts.AMOUNT

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("HOMEWORKLOG", "List: onCreateView")
        val columnCount: Int = if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT)
            Consts.PORTRAIT_COLUMNS
        else
            Consts.LANDSCAPE_COLUMNS

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        recycler.setItemViewCacheSize(Consts.CACHE_SIZE)
        recycler.layoutManager = GridLayoutManager(this.context, columnCount)

        if (savedInstanceState != null) {
            amount = savedInstanceState.getInt(Consts.LABEL)
        }

        val data = DataSource(amount)
        val adapter = Adapter(data)
        recycler.adapter = adapter

        val btn = view.findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            Log.d("HOMEWORKLOG", "btn: click")
            adapter.notifyItemInserted(data.add())
            amount = data.size() - 1
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Consts.LABEL, amount)
    }
}
