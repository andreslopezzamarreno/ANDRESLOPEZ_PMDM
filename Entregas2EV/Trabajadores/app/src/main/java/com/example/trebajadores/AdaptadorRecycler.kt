package com.example.trebajadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class AdaptadorRecycler(var contexto: Context, var usuarios: ArrayList<Usuario>) :
    Adapter<AdaptadorRecycler.MyHolder>() {

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoNombre: TextView
        var textoApellido: TextView

        init {
            textoNombre = itemView.findViewById(R.id.nombre_recycler)
            textoApellido = itemView.findViewById(R.id.apellido_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        //xml -> aspecto de cada fila
        var vista: View = LayoutInflater.from(contexto)
            .inflate(R.layout.usuario_recycler, parent, false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var interfaz = contexto as OnUsuarioListener
        var usuarioActual = usuarios.get(position)

        holder.textoNombre.setText(usuarioActual.nombre)
        holder.textoApellido.setText(usuarioActual.apellido)

        holder.itemView.setOnClickListener {
            interfaz.onUsuarioSelected(usuarioActual)
        }
    }

    override fun getItemCount(): Int {
        return usuarios.size
    }

    fun aniadirUsuario(usuario: Usuario) {
        usuarios.add(usuario)
        notifyItemInserted(usuarios.size - 1)
    }

    interface OnUsuarioListener {
        fun onUsuarioSelected(usuario: Usuario)
    }

}