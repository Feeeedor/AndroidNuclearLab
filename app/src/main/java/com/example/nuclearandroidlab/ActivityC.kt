package com.example.nuclearandroidlab
import com.example.nuclearandroidlab.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_c)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonOpenActivityA = findViewById<Button>(R.id.open_activitya_button)
        buttonOpenActivityA.setOnClickListener {
            val myIntent: Intent = Intent(
                this,     ActivityA::class.java
            )
            myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            this.startActivity(myIntent)
        }
        val taskIdText = findViewById<TextView>(R.id.taskc_id_text)
        taskIdText.text = this.taskId.toString()
        val activityIdText = findViewById<TextView>(R.id.activityc_id_text)
        activityIdText.text = this.hashCode().toString()
    }
}