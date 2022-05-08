package com.rufaidemir.besinlerkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rufaidemir.besinlerkitabi.model.Besin

class BesinDetailViewModel: ViewModel() {
    val besin =  MutableLiveData<Besin>()

    fun roomVerisiniAl(){
        var besin3 = Besin("Elma","5","5","8","9","655")
        besin.value = besin3
    }

}