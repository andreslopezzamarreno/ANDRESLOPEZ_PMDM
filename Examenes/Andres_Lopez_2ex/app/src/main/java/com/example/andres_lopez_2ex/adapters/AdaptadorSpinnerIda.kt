package com.example.andres_lopez_2ex.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.andres_lopez_2ex.Ciudad
import com.example.andres_lopez_2ex.R

class AdaptadorSpinnerIda(var context: Context,var lista:ArrayList<Ciudad>):BaseAdapter() {
    override fun getCount(): Int {
        return lista.size
    }

    override fun getItem(position: Int): Any {
        return lista.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = LayoutInflater.from(context).inflate(R.layout.item_spinner,parent,false)
        var imagen:ImageView = vista.findViewById(R.id.imagen_vuelo)
        var texto:TextView = vista.findViewById(R.id.texto_vuelo)
        var vuelo = lista.get(position)
        texto.text = vuelo.nombre
        imagen.setImageResource(vuelo.imagen)
        return vista
    }
}