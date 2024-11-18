package com.example.nuclearandroidlab
import android.content.Intent
import com.example.nuclearandroidlab.R
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_b)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val buttonOpenActivityC = findViewById<Button>(R.id.open_activityc_button)
        buttonOpenActivityC.setOnClickListener {
            val myIntent: Intent = Intent(
                this,     ActivityC::class.java
            )

            this.startActivity(myIntent)
        }
        val taskIdText = findViewById<TextView>(R.id.taskb_id_text)
        taskIdText.text = this.taskId.toString()
        val activityIdText = findViewById<TextView>(R.id.activityb_id_text)
        activityIdText.text = this.hashCode().toString()
    }
}