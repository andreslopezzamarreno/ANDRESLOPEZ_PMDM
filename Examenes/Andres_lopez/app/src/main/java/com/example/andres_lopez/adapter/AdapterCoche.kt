package com.example.andres_lopez.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.andres_lopez.Coche
import com.example.andres_lopez.R

class AdapterCoche(var context: Context, var listaCoches:ArrayList<Coche>) : BaseAdapter() {
    override fun getCount(): Int {
        return listaCoches.size
    }

    override fun getItem(p0: Int): Any {
        return listaCoches.get(p0)
   }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista :View = LayoutInflater.from(context).inflate(R.layout.modelos_view,p2,false)

        var coche:Coche = listaCoches.get(p0)

        var imagen = vista.findViewById<ImageView>(R.id.imagen)
        var nombre = vista.findViewById<TextView>(R.id.modelo)
        var etiqueta = vista.findViewById<ImageView>(R.id.etiqueta)

        imagen.setImageResource(coche.imagen)
        nombre.setText(coche.nombre)

        if (coche.combustible.equals("Hibrido")) {
            etiqueta.setImageResource(R.drawable.etiquetaeco)
        } else if (coche.combustible.equals("Electrico")) {
            etiqueta.setImageResource(R.drawable.etiqueta0)
        } else if (coche.combustible.equals("gasolina")) {
            if (coche.anio >= 2006) {
                etiqueta.setImageResource(R.drawable.etiquetac)
            } else if (coche.anio >= 2000 && coche.anio< 2006) {
               etiqueta.setImageResource(R.drawable.etiquetab)
            } else if (coche.anio < 2000) {
               etiqueta.setImageResource(R.drawable.etiquetaa)
            }
        } else if (coche.combustible.equals("Diesel")) {
            if (coche.anio >= 2015) {
               etiqueta.setImageResource(R.drawable.etiquetac)
            } else if (coche.anio >= 2004 && coche.anio < 2015) {
                etiqueta.setImageResource(R.drawable.etiquetab)
            } else if (coche.anio < 2004) {
                etiqueta.setImageResource(R.drawable.etiquetaa)
            }
        }
        return vista
    }
}