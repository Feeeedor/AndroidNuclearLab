package com.example.nuclearandroidlab

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import java.util.Random


class FragmentBB : Fragment(R.layout.fragment_b_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendColorButton = view.findViewById<Button>(R.id.send_color_button)
        sendColorButton.setOnClickListener {
            val randomColor = generateRandomColor()
            parentFragmentManager.setFragmentResult("colorRequestKey", bundleOf("color" to randomColor))


        }
    }

    private fun generateRandomColor(): Int {
        val rnd = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}