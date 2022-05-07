package com.rufaidemir.besinlerkitabi.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.rufaidemir.besinlerkitabi.R
import kotlinx.android.synthetic.main.fragment_besin_list.*

class BesinListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_besin_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        naviGationbesinListesi.setOnClickListener{
            val action = BesinListFragmentDirections.actionBesinListFragmentToBesinDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}