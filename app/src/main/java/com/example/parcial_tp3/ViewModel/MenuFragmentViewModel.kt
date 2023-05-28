package com.example.parcial_tp3.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcial_tp3.APIServiceBuilder.APIServiceBuilder
import com.example.parcial_tp3.Model.Brand
import com.example.parcial_tp3.Model.CarResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuFragmentViewModel : ViewModel() {
    val brandList: MutableLiveData<List<Brand>> = MutableLiveData<List<Brand>>()
    private val brandOrder: LinkedHashSet<String> = LinkedHashSet<String>()

    private fun loadBrands() {
        brandOrder.add("Macerati")
        brandOrder.add("Mercedes")
        brandOrder.add("TOGG")
        brandOrder.add("Porsche")
        brandOrder.add("BMW")
        brandOrder.add("Renault")
    }

    fun getBrands() {
        if (brandList.value == null) {
            loadBrands()
            val service = APIServiceBuilder.create()

            val brandResponses = mutableListOf<Brand>()

            for (brandName in brandOrder) {
                service.getCars(brandName).enqueue(
                    object : Callback<List<CarResponse>> {
                        override fun onResponse(
                            call: Call<List<CarResponse>>,
                            response: Response<List<CarResponse>>
                        ) {
                            val brand = Brand(
                                brandName.lowercase() + "_logo",
                                brandName,
                                response.body()!!.size
                            )
                            brandResponses.add(brand)

                            if (brandResponses.size == brandOrder.size) {
                                brandList.value = brandResponses
                            }
                        }

                        override fun onFailure(call: Call<List<CarResponse>>, t: Throwable) {
                            Log.e("RETROFIT", "An error occurred while requesting brand. ERROR: ${t.message}")
                        }
                    }
                )
            }
        }
    }
}