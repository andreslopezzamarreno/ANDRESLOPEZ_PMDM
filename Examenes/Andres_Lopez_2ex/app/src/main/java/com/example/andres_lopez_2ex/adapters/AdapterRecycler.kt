package com.example.andres_lopez_2ex.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andres_lopez_2ex.R
import com.example.andres_lopez_2ex.Vuelo
import com.google.android.material.snackbar.Snackbar

class AdapterRecycler(var contexto: Context,var lista:ArrayList<Vuelo>):RecyclerView.Adapter<AdapterRecycler.MyHolder>(){

    class MyHolder ( var vista: View): RecyclerView.ViewHolder(vista) {

         var infovuelo: TextView
         var imagenida: ImageView
         var imagenVuelta: ImageView
         var botonDetalle: Button


        init {
           infovuelo = vista.findViewById(R.id.info_vuelo)
           imagenida = vista.findViewById(R.id.imagen_ida)
           imagenVuelta = vista.findViewById(R.id.imagen_vuelta)
           botonDetalle = vista.findViewById(R.id.boton_detalle)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view: View = LayoutInflater.from(contexto).inflate(R.layout.item_recycler,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var vuelo: Vuelo = lista.get(position)
        holder.infovuelo.text = vuelo.info
        holder.imagenida.setImageResource(vuelo.imagenIda)
        holder.imagenVuelta.setImageResource(vuelo.imagenVuelta)

        holder.botonDetalle.setOnClickListener {
            Snackbar.make(holder.itemView,vuelo.horaIda + "  -   "+vuelo.horaVuelta,Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    fun aniadirVuelo(vuelo: Vuelo){
        lista.add(vuelo)
        notifyItemInserted(lista.size-1)
    }

}