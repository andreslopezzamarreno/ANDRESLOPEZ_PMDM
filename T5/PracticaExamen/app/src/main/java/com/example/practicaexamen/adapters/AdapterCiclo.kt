package com.example.practicaexamen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.practicaexamen.Ciclo
import com.example.practicaexamen.R

class AdapterCiclo(var lista:ArrayList<Ciclo>, var contexto: Context):BaseAdapter() {

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
        var vista = LayoutInflater.from(contexto).inflate(R.layout.item_ciclo,parent,false)

        var nombre: TextView = vista.findViewById(R.id.nombre_ciclo_item)
        var imagen: ImageView = vista.findViewById(R.id.imagen_ciclo_ciclo)

        var ciclo = lista.get(position)
        nombre.text = ciclo.nombre
        imagen.setImageResource(ciclo.imagen)

        return vista
    }
}