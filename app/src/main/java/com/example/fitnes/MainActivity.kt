package com.example.fitnes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import utils.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragments(DaysFragment.newInstance(),this)
    }
}