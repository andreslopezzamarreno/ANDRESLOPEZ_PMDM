package com.example.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import com.example.listas.adapters.ElementoAdapter
import com.example.listas.databinding.ActivityListasBinding

class listasActivity : AppCompatActivity(), OnItemSelectedListener {

    private lateinit var binding: ActivityListasBinding

    lateinit var arraySpinner: ArrayList<String>
    lateinit var adaptadorSencillo: ArrayAdapter<CharSequence>

    lateinit var adapatadorElemento: ElementoAdapter
    lateinit var listaCosas: ArrayList<Elemento>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun acciones() {
        binding.spinner.onItemSelectedListener = this

        binding.lista.setOnItemClickListener { adapterView, view, i, l ->
            var element:Elemento = adapatadorElemento.getItem(i) as Elemento
            binding.nombre.setText(element.nombre)
            binding.descripcion.setText(element.descripcion)
            binding.imagen.setImageResource(element.imagen)
        }
    }

    private fun asociarDatos() {
        binding.spinner.adapter = adaptadorSencillo
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        adaptadorSencillo = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.hobbies,
            android.R.layout.simple_spinner_item
        )
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        listaCosas = ArrayList()
        adapatadorElemento = ElementoAdapter(this, listaCosas)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0!!.id) {
            R.id.spinner -> {
                var hobbie: String = binding.spinner.selectedItem as String
                if (hobbie == "futbol") {
                    listaCosas.clear()
                    listaCosas.add(Elemento("Messi", "FC. Barcelona", R.drawable.messi))
                    listaCosas.add(Elemento("Ronaldo", "Brasil", R.drawable.ronaldo))
                    listaCosas.add(Elemento("Maradona", "Argentina", R.drawable.maradona))
                    listaCosas.add(Elemento("Zidane", "Francia", R.drawable.zidane))
                } else if (hobbie == "juegos") {
                    listaCosas.clear()
                    listaCosas.add(Elemento("Metal Gear", "Sigilo", R.drawable.metal))
                    listaCosas.add(Elemento("Gran Turismo", "Coches", R.drawable.gt))
                    listaCosas.add(Elemento("God Of War", "Plataformas", R.drawable.god))
                    listaCosas.add(Elemento("Final Fantasy X", "Rol", R.drawable.ffx))
                } else if (hobbie == "series") {
                    listaCosas.clear()
                    listaCosas.add(Elemento("Stranger Things", "Fantastica", R.drawable.stranger))
                    listaCosas.add(Elemento("Juego de tronos", "Histórica", R.drawable.tronos))
                    listaCosas.add(Elemento("Lost", "Fantastica", R.drawable.lost))
                    listaCosas.add(Elemento("La casa de papel", "Accion", R.drawable.papel))
                }
                binding.lista.adapter = adapatadorElemento
            }
            R.id.lista->{

            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}