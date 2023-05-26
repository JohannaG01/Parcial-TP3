package com.example.parcial_tp3.Model
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import java.io.Serializable

class Car(
    val name: String,
    val transmission: String,
    val fuel: String,
    val year: Int,
    val seats: Int,
    val logo: String
) {
    fun getLogoDrawable(context: Context): Drawable? {
        val resourceId = context.resources.getIdentifier(logo, "drawable", context.packageName)
        return ContextCompat.getDrawable(context, resourceId)
    }
}
