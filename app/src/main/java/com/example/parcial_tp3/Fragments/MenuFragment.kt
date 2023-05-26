package com.example.parcial_tp3.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.APIServiceBuilder.APIServiceBuilder
import com.example.parcial_tp3.Model.Brand
import com.example.parcial_tp3.Model.CarResponse
import com.example.parcial_tp3.R
import com.example.parcial_tp3.RecycleViewAdapter.BrandAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuFragment : Fragment() {
    lateinit var progressBar: ProgressBar
    lateinit var recycleBrands: RecyclerView
    lateinit var thisView: View
    val brandOrder: LinkedHashSet<String> = LinkedHashSet()
    var brandList: MutableList<Brand> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thisView = inflater.inflate(R.layout.fragment_menu, container, false)

        recycleBrands = thisView.findViewById(R.id.recycle_view_brands)
        progressBar = thisView.findViewById(R.id.progressBar)

        progressBar.visibility = View.VISIBLE
        recycleBrands.visibility = View.GONE
        getBrands()
        return thisView
    }

    private fun loadBrands(){
        brandOrder.add("Macerati")
        brandOrder.add("Mercedes")
        brandOrder.add("TOGG")
        brandOrder.add("Porsche")
        brandOrder.add("BMW")
        brandOrder.add("Renault")
    }
    private fun getBrands(){
        loadBrands()
        val service = APIServiceBuilder.create()

        for (brandName in brandOrder) {
            service.getCars(brandName).enqueue(object : Callback<List<CarResponse>> {
                override fun onResponse(
                    call: Call<List<CarResponse>>,
                    response: Response<List<CarResponse>>
                ) {
                    Log.i("RETROFIT", "$brandName Amount: ${response.body()?.size}")
                    addBrand(brandName, "${brandName.lowercase()}_logo", response.body()!!)
                    if (brandList.size == brandOrder.size) {
                        progressBar.visibility = View.GONE // Oculta la ProgressBar
                        recycleBrands.visibility = View.VISIBLE // Muestra el RecyclerView
                        showData()
                    }
                }

                override fun onFailure(call: Call<List<CarResponse>>, t: Throwable) {
                    //TODO
                }
            })
        }

    }
    private fun addBrand(brand: String, brandLogo: String, cars: List<CarResponse>){
        val brand = Brand(brandLogo, brand, cars.size)
        brandList.add(brand)
    }

    private fun showData(){
        recycleBrands.setHasFixedSize(true)

        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL

        recycleBrands.layoutManager = linearLayoutManager
        recycleBrands.adapter = BrandAdapter(brandList)
    }
}