package com.rufaidemir.besinlerkitabi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.rufaidemir.besinlerkitabi.R
import com.rufaidemir.besinlerkitabi.model.Besin
import com.rufaidemir.besinlerkitabi.view.BesinListFragmentDirections
import kotlinx.android.synthetic.main.besin_layout_recycler_row.view.*

class BesinRecyclerListAdapter(var besinListesi:ArrayList<Besin>):RecyclerView.Adapter<BesinRecyclerListAdapter.BesinViewHolder>() {
    class BesinViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BesinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.besin_layout_recycler_row, parent, false)
        return BesinViewHolder(view)
    }

    override fun onBindViewHolder(holder: BesinViewHolder, position: Int) {
        holder.itemView.textViewBesinName.text = besinListesi.get(position).besinIsim
        holder.itemView.textViewBesinKalori.text = besinListesi.get(position).besinKalori
//        TODO gorsel kismi eklenecek

        holder.itemView.setOnClickListener {
            val action  = BesinListFragmentDirections.actionBesinListFragmentToBesinDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return besinListesi.size
    }

    fun besinListesiniGuncelle(yeniBesinListesi:List<Besin>){
        besinListesi.clear()
        besinListesi.addAll(yeniBesinListesi)
        notifyDataSetChanged()
    }
}