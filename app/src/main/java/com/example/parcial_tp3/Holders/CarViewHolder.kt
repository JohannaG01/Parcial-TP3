package com.example.parcial_tp3.Holders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.R

class CarViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {

    val textName: TextView = itemView.findViewById(R.id.textView_car)

}
