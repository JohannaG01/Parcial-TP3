package com.example.parcial_tp3.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parcial_tp3.APIServiceBuilder.APIServiceBuilder
import com.example.parcial_tp3.Model.Brand
import com.example.parcial_tp3.Model.CarResponse
import com.example.parcial_tp3.R
import com.example.parcial_tp3.RecycleViewAdapter.BrandAdapter
import com.example.parcial_tp3.ViewModel.MenuFragmentViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuFragment : Fragment() {
    private val viewModel: MenuFragmentViewModel by viewModels()
    lateinit var progressBar: ProgressBar
    lateinit var recycleBrands: RecyclerView
    lateinit var thisView: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thisView = inflater.inflate(R.layout.fragment_menu, container, false)

        recycleBrands = thisView.findViewById(R.id.recycle_view_brands)
        progressBar = thisView.findViewById(R.id.progressBar)

        progressBar.visibility = View.VISIBLE
        recycleBrands.visibility = View.GONE


        viewModel.brandList.observe(viewLifecycleOwner) { brands ->
            if (brands.isNotEmpty()) {
                progressBar.visibility = View.GONE
                recycleBrands.visibility = View.VISIBLE
                showData(brands)
            }
        }

        viewModel.getBrands()

        return thisView
    }

    private fun showData(brandList: List<Brand>) {
        recycleBrands.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycleBrands.layoutManager = linearLayoutManager
        recycleBrands.adapter = BrandAdapter(brandList)
    }
}