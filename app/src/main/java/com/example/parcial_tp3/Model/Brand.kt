package com.example.parcial_tp3.Model


import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

class Brand (
    val logo: String,
    val name: String,
    val amount: Int
) {
    fun getLogoDrawable(context: Context): Drawable? {
        val resourceId = context.resources.getIdentifier(logo, "drawable", context.packageName)
        return ContextCompat.getDrawable(context, resourceId)
    }
}