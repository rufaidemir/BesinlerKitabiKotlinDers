package com.rufaidemir.besinlerkitabi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.rufaidemir.besinlerkitabi.R
import com.rufaidemir.besinlerkitabi.adapter.BesinRecyclerListAdapter
import com.rufaidemir.besinlerkitabi.viewmodel.BesinViewModel
import kotlinx.android.synthetic.main.fragment_besin_list.*

class BesinListFragment : Fragment() {

    private lateinit var besinListetiViewModel: BesinViewModel
    private val recyclerBesinListesiAdapter = BesinRecyclerListAdapter(arrayListOf())

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

        besinListetiViewModel = ViewModelProviders.of(this).get(BesinViewModel::class.java)
        besinListetiViewModel.refresData()

        besinListRecyclerView.layoutManager = LinearLayoutManager(context)
        besinListRecyclerView.adapter = recyclerBesinListesiAdapter

        observeLiveData()
    }

    fun observeLiveData(){
        besinListetiViewModel.besinler.observe(viewLifecycleOwner, Observer { besinler ->
            besinler?.let {
                besinListRecyclerView.visibility = View.VISIBLE
                recyclerBesinListesiAdapter.besinListesiniGuncelle(besinler)
            }
        })

        besinListetiViewModel.besinHataMesaji.observe(viewLifecycleOwner, Observer { hata->
            hata?.let{
                if (it){
                    textViewError.visibility = View.VISIBLE
                    textViewError.text = "BIR HATA OLUSTU.."
                }else{
                    textViewError.visibility = View.GONE
                    besinListRecyclerView.visibility = View.GONE
                }
            }
        })

        besinListetiViewModel.besinIsLoadind.observe(this, Observer { loading->
            loading?.let {
                if (it){
                    besinListRecyclerView.visibility = View.GONE
                    textViewError.visibility = View.GONE
                    progressBar.visibility = View.VISIBLE
                }else{
                    progressBar.visibility = View.GONE

                }
            }
        })
    }
}