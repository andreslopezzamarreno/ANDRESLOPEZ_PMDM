package com.example.andres_lopez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import com.example.andres_lopez.adapter.AdapterCoche
import com.example.andres_lopez.databinding.ActivityMainBinding
import com.example.andres_lopez.databinding.ActivityModelosBinding
import com.example.andres_lopez.databinding.ModelosViewBinding
import com.google.android.material.snackbar.Snackbar

class ModelosActivity : AppCompatActivity(),OnItemClickListener {

    private lateinit var binding:ActivityModelosBinding
    private lateinit var arrayCoches :ArrayList<Coche>
    private lateinit var adapterCoche:AdapterCoche

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModelosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rellenarDatos()
        asociarDatos()
        acciones()
    }

    private fun acciones() {
        binding.lista.onItemClickListener = this
    }

    private fun asociarDatos() {
        adapterCoche = AdapterCoche(this, arrayCoches)
        binding.lista.adapter = adapterCoche
    }

    private fun rellenarDatos() {
        arrayCoches = ArrayList()
        arrayCoches.add(Coche("Leon","Seat",2008,"gasolina",R.drawable.leon))
        arrayCoches.add(Coche("Ibiza","Seat",2000,"gasolina",R.drawable.ibiza))
        arrayCoches.add(Coche("Cordoba","Seat",1996,"Diesel",R.drawable.cordoba))
        arrayCoches.add(Coche("Golf","volkswagen",2008,"gasolina",R.drawable.golf))
        arrayCoches.add(Coche("Tiguan","volkswagen",2008,"Hibrido",R.drawable.tiguan))
        arrayCoches.add(Coche("Arteon","volkswagen",2013,"gasolina",R.drawable.arteon))
        arrayCoches.add(Coche("Corsa","opel",2008,"gasolina",R.drawable.corsa))
        arrayCoches.add(Coche("Astra","opel",2022,"gasolina",R.drawable.astra))
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p0!!.id){
            R.id.lista->{
                var coche = binding.lista.adapter.getItem(p2) as Coche
                var snackbar = Snackbar.make(binding.lista, coche.combustible + "  "+coche.anio, Toast.LENGTH_SHORT).show()
            }

        }
    }
}