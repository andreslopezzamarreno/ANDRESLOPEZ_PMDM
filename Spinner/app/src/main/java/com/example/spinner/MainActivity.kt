package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.graphics.drawable.toDrawable
import com.example.spinner.adapatadores.AdaptadorPersonalizado
import com.example.spinner.databinding.ActivityMainBinding
import com.example.spinner.modelo.Pais
import kotlin.math.log

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    lateinit var arraySpinner: ArrayList<Pais>
    lateinit var adaptadorSencillo:ArrayAdapter<CharSequence>
    lateinit var adaptadorPersonalizado: AdaptadorPersonalizado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun rellenarSpinnerPersonalizado() {
        arraySpinner.add(Pais("España",R.drawable.espania))
        arraySpinner.add(Pais("Brasil",R.drawable.brasil))
        arraySpinner.add(Pais("Alemania",R.drawable.alemania))
        arraySpinner.add(Pais("Francia",R.drawable.francia))
        arraySpinner.add(Pais("Qatar",R.drawable.qatar))

    }


    private fun instancias() {
        arraySpinner = ArrayList()
        adaptadorSencillo = ArrayAdapter.createFromResource(applicationContext,R.array.paises,android.R.layout.simple_spinner_item)
        adaptadorSencillo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        rellenarSpinnerPersonalizado()
        adaptadorPersonalizado = AdaptadorPersonalizado(arraySpinner,this)
    }

    private fun asociarDatos() {
        binding.spinnerSimple.adapter = adaptadorSencillo
        binding.spinnerComplejo.adapter = adaptadorPersonalizado

    }

    private fun acciones() {
        binding.spinnerSimple.onItemSelectedListener = this
        binding.spinnerComplejo.onItemSelectedListener = this
        binding.botonAgregar.setOnClickListener {
            //adaptadorPersonalizado.agregarPais()
            var pais:Pais = binding.spinnerComplejo.selectedItem as Pais
            binding.imagenPais.setImageResource(pais.imagen)
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p1!!.id){
            R.id.spinner_simple->{
            }
            R.id.spinner_complejo->{
                /*var pais:Pais = adaptadorPersonalizado.getItem(p2) as Pais
                binding.imagenPais.setImageResource(pais.imagen)*/
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}
