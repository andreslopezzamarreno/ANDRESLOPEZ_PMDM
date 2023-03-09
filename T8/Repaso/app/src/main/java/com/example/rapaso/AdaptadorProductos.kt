package com.example.rapaso

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AdaptadorProductos(var contexto: Context, var listaDatos: List<Producto>) :
    RecyclerView.Adapter<AdaptadorProductos.MyHolder>() {

    class MyHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var nombre: TextView
        var precio: TextView
        var favoritos: CheckBox

        init {
            nombre = view.findViewById(R.id.nombre_producto_recycler)
            precio = view.findViewById(R.id.precio_producto_recycler)
            favoritos = view.findViewById(R.id.check_favoritos)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View =
            LayoutInflater.from(contexto).inflate(R.layout.item_recycler, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var db = FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        var producto: Producto = listaDatos.get(position)
        holder.nombre.setText(producto.nombre)
        holder.precio.setText(producto.precio)

        holder.favoritos.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){

            }
        }
    }


    override fun getItemCount(): Int {
        return listaDatos.size
    }

    fun actualizarLista(productosLista: ArrayList<Producto>) {
        listaDatos = productosLista
        notifyDataSetChanged()
    }

}