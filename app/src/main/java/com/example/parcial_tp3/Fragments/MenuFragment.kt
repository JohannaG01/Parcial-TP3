package com.example.parcial_tp3.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.APIServiceBuilder.APIServiceBuilder
import com.example.parcial_tp3.APIServiceBuilder.CarService
import com.example.parcial_tp3.Model.Brand
import com.example.parcial_tp3.Model.CarResponse
import com.example.parcial_tp3.R
import com.example.parcial_tp3.RecycleViewAdapter.BrandAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuFragment : Fragment() {
    lateinit var thisView: View
    lateinit var brandMap: Map<String, String>
    var brandList: MutableList<Brand> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thisView = inflater.inflate(R.layout.fragment_menu, container, false)
        getBrands()
        return thisView
    }

    private fun loadBrandMaps(){
        brandMap = mapOf(
            "Macerati" to "macerati_logo",
            "Mercedes" to "mercedes_logo",
            "TOGG" to "togg_logo",
            "Porsche" to "porsche_logo",
            "BMW" to "bmw_logo",
            "Renault" to "renault_logo"
        )

    }
    private fun getBrands(){
        val service = APIServiceBuilder.create()

        service.getCars("Mercedes").enqueue(object: Callback<List<CarResponse>> {

            override fun onResponse(
                call: Call<List<CarResponse>>,
                response: Response<List<CarResponse>>
            ){
                Log.i("RETROFIT", "Mercedes Amount: " + response.body()!!.size.toString())
                addBrand("Mercedes", "mercedes_logo", response.body()!!)
                showData()
            }

            override fun onFailure(call: Call<List<CarResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
    private fun addBrand(brand: String, brandLogo: String, cars: List<CarResponse>){
        val brand = Brand("mercedes_logo", brand, cars.size)
        brandList.add(brand)
    }

    private fun showData(){
        val recycleBrands = thisView.findViewById<RecyclerView>(R.id.recycle_view_brands)
        recycleBrands.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        recycleBrands.layoutManager = linearLayoutManager
        recycleBrands.adapter = BrandAdapter(brandList)
    }
}