package com.example.hw

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("HOMEWORKLOG", "MainActivity: onCreate")

        if (supportFragmentManager.findFragmentById(R.id.wrapper) == null) {
            val fm = supportFragmentManager.beginTransaction()
            fm.add(R.id.wrapper, List())
            fm.commit()
        }
    }
}
