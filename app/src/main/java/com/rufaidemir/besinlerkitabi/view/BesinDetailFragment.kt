package com.rufaidemir.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rufaidemir.besinlerkitabi.R
import com.rufaidemir.besinlerkitabi.viewmodel.BesinDetailViewModel
import kotlinx.android.synthetic.main.fragment_besin_detail.*

class BesinDetailFragment : Fragment() {

    private lateinit var besinDetayiViewModel : BesinDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        besinDetayiViewModel =  ViewModelProviders.of(this).get(BesinDetailViewModel::class.java)
        besinDetayiViewModel.roomVerisiniAl()
    }

    fun observeLiveData(){
        besinDetayiViewModel.besin.observe(viewLifecycleOwner, Observer { besin->
            besin?.let {
                textViewDetailBesinIsmi.text = besin.besinIsim
                textViewDetailBesinKalori.text = besin.besinKalori
                textViewDetailBesinProtein.text = besin.besinProtein
                textViewDetailBesinYag.text = besin.besinYag
                textViewDetailBesinKarbonhidrat.text = besin.besinKarbonhidrat
            }
        })
    }
}