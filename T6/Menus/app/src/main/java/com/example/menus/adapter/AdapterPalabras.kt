package com.example.menus.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.menus.R
import kotlin.math.log

class AdapterPalabras(var contexto: Context, var listaDatos: ArrayList<String >):
    RecyclerView.Adapter<AdapterPalabras.MyHolder>(){

    inner class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {
        var nombre: TextView

        init {
            nombre = view.findViewById(R.id.texto)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.recycler_palabras,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.nombre.setText(listaDatos[position])
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    fun addPalabra(nombre: String){
        this.listaDatos.add(nombre)
        this.notifyItemInserted(listaDatos.size-1)
    }

    fun clearPalabra(){
        this.listaDatos.clear()
        this.notifyDataSetChanged()
    }
}