package com.example.nuclearandroidlab


import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.nuclearandroidlab.utils.colorUtils



class FragmentBB : Fragment(R.layout.fragment_b_b) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sendColorButton = view.findViewById<Button>(R.id.send_color_button)
        sendColorButton.setOnClickListener {
            val randomColor = colorUtils.generateRandomColor()
            parentFragmentManager.setFragmentResult("colorRequestKey", bundleOf("color" to randomColor))
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                parentFragmentManager.popBackStack();
            }
        }
    }


}