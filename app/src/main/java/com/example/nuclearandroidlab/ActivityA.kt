package com.example.nuclearandroidlab

import android.R.attr.value
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
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
            val myIntent: Intent = Intent(
                this,     ActivityB::class.java
            )
            myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK
            this.startActivity(myIntent)
        }
        val buttonOpenFragmentB = findViewById<Button>(R.id.open_fragmentb_button)
        buttonOpenFragmentB.setOnClickListener {


                if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fragment_container_ba, FragmentBA())
                            .replace(R.id.fragment_container_bb, FragmentBB())
                            .commit()

                } else {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_ba, FragmentBA())

                        .commit()
                }

        }
        val taskIdText = findViewById<TextView>(R.id.taska_id_text)
        taskIdText.text =  this.taskId.toString()
        val activityIdText = findViewById<TextView>(R.id.activitya_id_text)
        activityIdText.text = this.hashCode().toString()
    }



}