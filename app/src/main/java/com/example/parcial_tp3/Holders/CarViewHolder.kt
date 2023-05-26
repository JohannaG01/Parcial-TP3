package com.example.parcial_tp3.Holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.R

class CarViewHolder(v : View): RecyclerView.ViewHolder(v) {

    private var view: View

    init {
        this.view = v
    }

    fun setName(name: String) {
        val txt = this.view.findViewById<TextView>(R.id.textView_car)
        txt.text = name
    }

    fun getContainer(): View {
        return this.view.findViewById<View>(R.id.cardViewLayout)
    }
}
