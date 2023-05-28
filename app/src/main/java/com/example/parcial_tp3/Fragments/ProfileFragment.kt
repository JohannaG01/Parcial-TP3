package com.example.parcial_tp3.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.parcial_tp3.MainActivity
import com.example.parcial_tp3.R
import com.example.parcial_tp3.ViewModel.ProfileFragmentViewModel

class ProfileFragment : Fragment() {
    lateinit var thisView: View
    lateinit var txtname: TextView
    lateinit var viewModel: ProfileFragmentViewModel
    lateinit var username: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity: MainActivity? = activity as MainActivity?
        username = activity?.getUsername().toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        thisView = inflater.inflate(R.layout.fragment_profile, container, false)
        txtname = thisView.findViewById(R.id.txt_name)

        viewModel = ViewModelProvider(requireActivity()).get(ProfileFragmentViewModel::class.java)

        viewModel.name.observe(viewLifecycleOwner) { result ->
            txtname.text = result
        }

        viewModel.name.postValue(username)

        return thisView
    }
}