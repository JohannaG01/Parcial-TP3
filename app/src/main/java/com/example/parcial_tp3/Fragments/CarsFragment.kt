package com.example.parcial_tp3.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.Adapters.CarListAdapter
import com.example.parcial_tp3.Entities.Car
import com.example.parcial_tp3.R

class CarsFragment : Fragment() {

    var carList: MutableList<Car> = ArrayList<Car>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val thisView = inflater.inflate(R.layout.fragment_cars, container, false)

        val recycleCars = thisView.findViewById<RecyclerView>(R.id.recycle_view_cars)

        for(i in 1..3){
            carList.add(Car("Auto $i", "null", "null", 2020, 4, ""))
        }
        recycleCars.adapter = CarListAdapter(carList)

        return thisView
    }

}