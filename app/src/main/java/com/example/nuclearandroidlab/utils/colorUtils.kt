package com.example.nuclearandroidlab.utils


import android.graphics.Color




object colorUtils {



     fun generateRandomColor(): Int {
        val rnd = java.util.Random()
        return Color.argb(255,
            rnd.nextInt(256),
            rnd.nextInt(256),
            rnd.nextInt(256))
    }



    fun setBackgroundColor(view: android.view.View, color: Int? = null) {
        val randomColor = color ?: generateRandomColor()
        view.setBackgroundColor(randomColor)
    }
}