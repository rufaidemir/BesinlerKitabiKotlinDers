package com.rufaidemir.besinlerkitabi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rufaidemir.besinlerkitabi.model.Besin

class BesinViewModel : ViewModel() {
    val besinler = MutableLiveData<List<Besin>>()
    val besinHataMesaji = MutableLiveData<Boolean>()
    val besinIsLoadind = MutableLiveData<Boolean>()

    fun refresData(){
        var besin1 = Besin("Muz","5","5","8","9","655")
        var besin2 = Besin("Cilek","5","5","8","9","655")
        var besin3 = Besin("Elma","5","5","8","9","655")

        val besinListesi  = arrayListOf<Besin>(besin1,besin2, besin3)

        besinler.value = besinListesi
        besinHataMesaji.value=false
        besinIsLoadind.value=false


    }
}