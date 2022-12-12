package com.example.listasrecyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listasrecyclerview.R
import com.example.listasrecyclerview.model.Usuario

class AdaptadorUsuarios(var lista: ArrayList<Usuario>,var contexto: Context) :RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista:View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false) //xml -> aspect de cada fila
        return MyHolder(vista)
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position)
        holder.textoNombre.setText(usuarioActual.nombre)
        holder.textoApellido.setText(usuarioActual.apellido)
        holder.imagenUsuario.setImageResource(usuarioActual.imagen)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        lateinit var textoNombre :TextView
        lateinit var textoApellido :TextView
        lateinit var imagenUsuario : ImageView

        init {
            textoNombre = itemView.findViewById(R.id.nombre_item)
            textoApellido = itemView.findViewById(R.id.apellido_item)
        }
    }
}