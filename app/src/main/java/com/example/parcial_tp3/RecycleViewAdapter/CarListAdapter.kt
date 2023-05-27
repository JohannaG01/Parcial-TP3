package com.example.parcial_tp3.RecycleViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.Model.Car
import com.example.parcial_tp3.R


class CarListAdapter(
    private val carList: MutableList<Car>
) : RecyclerView.Adapter<CarListAdapter.CarViewHolder>() {

    class CarViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textView_car)
        val logo: ImageView = itemView.findViewById(R.id.car_logo)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.car_item_view, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = carList[position]
        val context = holder.itemView.context
        val logoDrawable = car.getLogoDrawable(context)

        holder.logo.setImageDrawable(logoDrawable)
        holder.textName.text = car.name
    }
}
