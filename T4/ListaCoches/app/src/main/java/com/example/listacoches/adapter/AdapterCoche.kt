package com.example.listacoches.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.listacoches.DetalleActivity
import com.example.listacoches.R
import com.example.listacoches.model.Coche

class AdapterCoche(var listaCoche:ArrayList<Coche>, var contexto:Context):
    RecyclerView.Adapter<AdapterCoche.MyHolder>() {

    private  var listener: OnRecyclerCocheListener

    init {
        listener = contexto as OnRecyclerCocheListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var vista :View = LayoutInflater.from(contexto).inflate(R.layout.item_listas,parent,false)
        return MyHolder(vista)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var cocheActual = listaCoche.get(position)
        holder.textoModelo.setText(cocheActual.modelo)
        holder.imageView.setImageResource(cocheActual.imagen)

        holder.boton.setOnClickListener{
            /*var intent: Intent = Intent(contexto, DetalleActivity::class.java)
            var datos: Bundle = Bundle()
            datos.putSerializable("coche",cocheActual)
            intent.putExtras(datos)
            startActivity(contexto,intent,datos)*/

            //listener.OnCocheSelected(cocheActual)

            funcionComunicar?.invoke(cocheActual)

        }
    }

    override fun getItemCount(): Int {
        return listaCoche.size
    }

    fun cambioLista(listaNueva: ArrayList<Coche>){
        this.listaCoche = listaNueva
        notifyDataSetChanged()
    }

    interface OnRecyclerCocheListener{
        fun OnCocheSelected(coche: Coche)
    }

    var funcionComunicar: ((coche: Coche)->Unit)? = null

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textoModelo : TextView
        var boton : Button
        var imageView : ImageView

        init {
            textoModelo = itemView.findViewById(R.id.textoModelo)
            boton = itemView.findViewById(R.id.boton)
            imageView = itemView.findViewById(R.id.imageView)
        }
    }
}