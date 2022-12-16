package com.example.listasrecyclerview.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listasrecyclerview.MainActivity
import com.example.listasrecyclerview.R
import com.example.listasrecyclerview.model.Usuario
import com.google.android.material.snackbar.Snackbar

class AdaptadorUsuarios(var lista: ArrayList<Usuario>,var contexto: Context) :RecyclerView.Adapter<AdaptadorUsuarios.MyHolder>(){

    private var listener: OnRecyclerUsuarioListener

    init {
        listener = contexto as OnRecyclerUsuarioListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista:View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false) //xml -> aspecto de cada fila
        return MyHolder(vista)
    }


    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var usuarioActual = lista.get(position)
        holder.textoNombre.setText(usuarioActual.nombre)
        holder.textoApellido.setText(usuarioActual.apellido)
        holder.imagenUsuario.setImageResource(usuarioActual.imagen)

        //holder.constraintLayout.setOnClickListener{}

        holder.textoNombre.setOnClickListener{
            listener.onUsuarioSelected(usuarioActual)
        }

        //holder.textoNombre.setOnClickListener { Log.v("lista", "Texto nombre pulsado") }
        holder.textoApellido.setOnClickListener { Log.v("lista", "Texto nombre pulsado") }
        holder.imagenUsuario.setOnClickListener {
            Snackbar.make(
                holder.imagenUsuario,
                "Pulsada imagen",
                Snackbar.LENGTH_SHORT
            ).show()
        }

        holder.imagenUsuario.setOnLongClickListener{
            listener.onUsuarioSelected(usuarioActual,position)
            return@setOnLongClickListener true
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    interface OnRecyclerUsuarioListener{
        fun onUsuarioSelected(usuario: Usuario)

        fun onUsuarioSelected(usuario: Usuario,position: Int)
    }

    inner class MyHolder(itemView: View) : ViewHolder(itemView) {
        var textoNombre :TextView
        var textoApellido :TextView
        var imagenUsuario : ImageView
        var constraintLayout: ConstraintLayout

        init {
            constraintLayout = itemView.findViewById(R.id.constraintLayout)
            textoApellido = itemView.findViewById(R.id.apellido_item)
            textoNombre = itemView.findViewById(R.id.nombre_item)
            imagenUsuario = itemView.findViewById(R.id.imagen_item)
        }
    }
}