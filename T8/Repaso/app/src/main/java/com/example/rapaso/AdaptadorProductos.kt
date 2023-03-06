package com.example.rapaso

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProductos(var contexto: Context, var listaDatos: List<Producto>):
    RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    class MyHolder ( var view: View): RecyclerView.ViewHolder(view) {
         var nombre: TextView
        lateinit var precio: TextView

        init {
            nombre = view.findViewById(R.id.nombre_producto_recycler)
            precio = view.findViewById(R.id.precio_producto_recycler)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var producto: Producto = listaDatos.get(position)
        holder.nombre.setText(producto.nombre)
        holder.precio.setText(producto.precio)
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }

    fun actualizarLista(productosLista:ArrayList<Producto>){
        listaDatos = productosLista
        notifyDataSetChanged()
    }

}