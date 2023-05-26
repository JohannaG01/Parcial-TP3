package com.example.parcial_tp3.RecycleViewAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.Model.Brand
import com.example.parcial_tp3.R

class BrandAdapter (
    private val brandList: List<Brand>
): RecyclerView.Adapter<BrandAdapter.ViewHolder>(){

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val logo: ImageView = itemView.findViewById(R.id.brand_logo)
        val brandName: TextView = itemView.findViewById(R.id.brand_name)
        val brandAmount: TextView = itemView.findViewById(R.id.brand_amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.brand_div, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = brandList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val brand = brandList[position]
        val context = holder.itemView.context
        val logoDrawable = brand.getLogoDrawable(context)

        holder.logo.setImageDrawable(logoDrawable)
        holder.brandName.text = brand.name
        holder.brandAmount.text = brand.amount.toString()
    }
}