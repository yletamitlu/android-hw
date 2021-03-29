package com.example.hw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentById(R.id.wrapper) == null) {
            val fm = supportFragmentManager.beginTransaction()
            fm.add(R.id.wrapper, ListFragment())
            fm.commit()
        }
    }
}
