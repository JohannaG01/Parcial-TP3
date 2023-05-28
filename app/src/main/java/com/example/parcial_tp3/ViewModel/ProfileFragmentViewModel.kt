package com.example.parcial_tp3.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileFragmentViewModel : ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData<String>()
}