package com.example.practicaexamen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.practicaexamen.Asignatura
import com.example.practicaexamen.R
import com.example.practicaexamen.dialogs.DialogoMostrarAsignatura

class RecyclerAdapter(var contexto: Context, var lista:ArrayList<Asignatura>,var soporte:FragmentManager):
    RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {

    inner class MyHolder(var view: View):RecyclerView.ViewHolder(view){
        var nombre:TextView

        init {
            nombre = view.findViewById(R.id.texto_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = LayoutInflater.from(contexto).inflate(R.layout.recycler_asignaturas,parent,false)

        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.nombre.setText(lista[position].siglas)

        holder.itemView.setOnClickListener {
            val dialogo = DialogoMostrarAsignatura.newInstance(lista[position])
            dialogo.show(soporte,"")
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun aniadirAsignatura(asignatura: Asignatura){
        this.lista.add(asignatura)
        this.notifyItemInserted(lista.size-1)
    }
}