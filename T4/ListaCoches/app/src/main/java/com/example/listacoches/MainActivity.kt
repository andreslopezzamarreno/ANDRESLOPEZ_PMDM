package com.example.listacoches

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listacoches.adapter.AdapterCoche
import com.example.listacoches.databinding.ActivityMainBinding
import com.example.listacoches.model.Coche

class MainActivity : AppCompatActivity(),AdapterCoche.OnRecyclerCocheListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaCoches:ArrayList<Coche>
    private lateinit var adaptadorCoche: AdapterCoche


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        instancias()
        configurarRecycler()
        acciones()
    }

    private fun acciones() {

    }

    private fun configurarRecycler() {
        // 2. poner un adaptador dentro del recycler
        binding.listaRecycler.adapter = adaptadorCoche
        // 3. poner un layout dentro del recycler --> Linear Grid
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){

            binding.listaRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        }else{
            binding.listaRecycler.layoutManager = GridLayoutManager(this,2)
        }
    }

    private fun instancias() {
        //1. tener una lista de datos a representar
        listaCoches = ArrayList()
        listaCoches.add(Coche("Mercedes","AMG GT",200,149048,R.drawable.amggt))
        listaCoches.add(Coche("Bentley","Continental",200,245676,R.drawable.continental))
        listaCoches.add(Coche("Jaguar","Ftype",200,76450,R.drawable.ftype))
        listaCoches.add(Coche("Ford","GT40",200,2500000,R.drawable.gt40))
        listaCoches.add(Coche("Nissan","GTR",200,111290,R.drawable.gtr))
        listaCoches.add(Coche("Pagani","Huayra",200,2600000,R.drawable.huayra))
        listaCoches.add(Coche("Lexus","Lc",200,130500,R.drawable.lc))
        listaCoches.add(Coche("Ferrari","La Ferrari",200,1300000,R.drawable.leferrari))
        listaCoches.add(Coche("Maclaren","MC720",200,284700,R.drawable.mc600))
        listaCoches.add(Coche("Toyota","Supra",200,56550,R.drawable.supra))
        listaCoches.add(Coche("Porsche","Taycan",200,91024,R.drawable.taycan))
        adaptadorCoche = AdapterCoche(listaCoches,this)

        binding.spinnerMarca.adapter =ArrayAdapter.createFromResource(applicationContext,R.array.lista_marcas,android.R.layout.simple_spinner_item)
        (binding.spinnerMarca.adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrecio.adapter =ArrayAdapter.createFromResource(applicationContext,R.array.lista_precios,android.R.layout.simple_spinner_item)
        (binding.spinnerPrecio.adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    }

    override fun OnCocheSelected(coche: Coche) {
        var intent: Intent = Intent(applicationContext, DetalleActivity::class.java)
        var datos: Bundle = Bundle()
        datos.putSerializable("coche",coche)
        intent.putExtras(datos)
        startActivity(intent)
    }
}