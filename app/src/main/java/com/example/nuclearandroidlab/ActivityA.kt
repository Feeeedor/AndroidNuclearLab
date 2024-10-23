package com.example.nuclearandroidlab

import com.example.nuclearandroidlab.R
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonOpenActivityB = findViewById<Button>(R.id.open_activityb_button)
        buttonOpenActivityB.setOnClickListener {
            /*
            Какое-то действие
             */
        }
        val buttonOpenFragmentB = findViewById<Button>(R.id.open_fragmentb_button)
        buttonOpenFragmentB.setOnClickListener {
            /*
            Какое-то действие
             */
        }
    }



}