package com.example.spinner.adapatadores


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.spinner.R
import com.example.spinner.modelo.Pais

class AdaptadorPersonalizado(var listaElementos: ArrayList<Pais>, var contexto:Context) : BaseAdapter() {
    override fun getCount(): Int {
        //retornar el numero de elementos que el spinner tiene que pintar
        return listaElementos.size
    }

    override fun getItem(p0: Int): Any {
        //retorna el elemento que esta en una posicion indicada como parametro
        return listaElementos.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        //retorna el long asociado a un elemento que esta en una posicion indicada como parametro
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        //ertorna la vista (fila) ya rellena con los datos que estan en una posicion indicada ->p0
        //para poder rellenar la fila ya rellena -> XML
        var vista :View = LayoutInflater.from(contexto).inflate(R.layout.item_spinner,p2,false)

        var nombre:TextView = vista.findViewById(R.id.texto_fila)
        var imagen:ImageView = vista.findViewById(R.id.imagen_fila)

        var elemento = listaElementos.get(p0)
        nombre.text = elemento.nombre
        imagen.setImageResource(elemento.imagen)

        return vista
    }

    fun agregarPais(pais: Pais){
        listaElementos.add(pais)
        notifyDataSetChanged()
    }
}