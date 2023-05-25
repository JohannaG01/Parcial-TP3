package com.example.parcial_tp3.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.parcial_tp3.R


class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val thisView = inflater.inflate(R.layout.fragment_login, container, false)

        val btnToMenuFragment = thisView.findViewById<Button>(R.id.btn_login)

        btnToMenuFragment.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToMenuFragment()
            thisView.findNavController().navigate(action)
        }
        return thisView
    }

}