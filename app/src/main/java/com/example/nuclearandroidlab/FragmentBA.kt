package com.example.nuclearandroidlab


import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.nuclearandroidlab.utils.colorUtils

class FragmentBA : Fragment(R.layout.fragment_b_a) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            val buttonOpenFragmentBB = view.findViewById<Button>(R.id.open_fragment_bb_button)
            buttonOpenFragmentBB.setOnClickListener {
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_b_vertical, FragmentBB())
                        .addToBackStack(null)
                        .commit()
                }

            }
        }
        parentFragmentManager.setFragmentResultListener("colorRequestKey", viewLifecycleOwner)
        { _, bundle ->
            val color = bundle.getInt("color", Color.WHITE)
           colorUtils.setBackgroundColor(view, color)
        }

    }

}