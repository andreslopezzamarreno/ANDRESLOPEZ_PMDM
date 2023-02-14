package com.example.fragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class RecyclerAdapter(var listaUsuarios:ArrayList<Usuario>,var context: Context):RecyclerView.Adapter<RecyclerAdapter.MyHolder>(){

    inner class MyHolder(itemView: View) :ViewHolder(itemView){

        var imagen:ImageView
        var nombre: TextView

        init {
            imagen = itemView.findViewById(R.id.image_recycler)
            nombre = itemView.findViewById(R.id.text_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)

        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        val usuario:Usuario = listaUsuarios[position]
        holder.nombre.text = usuario.nombre
        if (usuario.sexo.equals("H",true)){
            holder.imagen.setImageResource(R.drawable.hombre)
        }else {
            holder.imagen.setImageResource(R.drawable.mujer)
        }

    }

    override fun getItemCount(): Int {
        return listaUsuarios.size
    }


    fun aniadirUsuario(usuario: Usuario){
        listaUsuarios.add(usuario)
        notifyItemInserted(listaUsuarios.size-1)
    }

}