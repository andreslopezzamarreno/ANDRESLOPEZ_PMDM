package com.example.listas.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.listas.Elemento
import com.example.listas.R

class ElementoAdapter(var contexto:Context,var liscaCosas:ArrayList<Elemento>):BaseAdapter() {
    override fun getCount(): Int {
        return liscaCosas.size
    }

    override fun getItem(p0: Int): Any {
        return liscaCosas.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista :View = LayoutInflater.from(contexto).inflate(R.layout.elemento_lista,p2,false)

        var elemento: Elemento = liscaCosas.get(p0)

        var nombreItem:TextView = vista.findViewById(R.id.nombre)
        var descripcionItem:TextView = vista.findViewById(R.id.descripcion)
        var imagenItem:ImageView = vista.findViewById(R.id.imagen)

        nombreItem.setText(elemento.nombre)
        descripcionItem.setText(elemento.descripcion)
        imagenItem.setImageResource(elemento.imagen)
        return vista
    }
}