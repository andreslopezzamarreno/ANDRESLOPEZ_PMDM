package com.example.listacoches

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listacoches.adapter.AdapterCoche
import com.example.listacoches.databinding.ActivityMainBinding
import com.example.listacoches.model.Coche

class MainActivity : AppCompatActivity(), AdapterCoche.OnRecyclerCocheListener,
    OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaCoches: ArrayList<Coche>
    private lateinit var listaFiltrada: ArrayList<Coche>
    private lateinit var adaptadorCoche: AdapterCoche
    private lateinit var precio:String
    private lateinit var marca :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()
        configurarRecycler()
        acciones()
    }

    private fun acciones() {
        binding.spinnerMarca.onItemSelectedListener = this
        binding.spinnerPrecio.onItemSelectedListener = this
    }


    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p0!!.id) {
            binding.spinnerMarca.id -> {
                val marca = binding.spinnerMarca.adapter.getItem(p2)
                //metodo filter da una lista ya filtrada sobre una condicion
                if(marca == "Todos"){
                    adaptadorCoche.cambioLista(listaCoches)
                }else {
                    listaFiltrada = listaCoches.filter { it.marca == marca } as ArrayList<Coche>
                    adaptadorCoche.cambioLista(listaFiltrada)
                }

            }
            binding.spinnerMarca.id -> {
                val precio = binding.spinnerPrecio.adapter.getItem(p2)
                when (p2){
                    0->{
                        adaptadorCoche.cambioLista(listaCoches)
                    }
                    1->{adaptadorCoche.cambioLista(adaptadorCoche.listaCoche.filter { it.precio<=100000 }as ArrayList<Coche>)}
                    2->{adaptadorCoche.cambioLista(adaptadorCoche.listaCoche.filter { it.precio<=200000 }as ArrayList<Coche>)}
                    3->{adaptadorCoche.cambioLista(adaptadorCoche.listaCoche.filter { it.precio<=300000 }as ArrayList<Coche>)}
                    4->{adaptadorCoche.cambioLista(adaptadorCoche.listaCoche.filter { it.precio<=400000 }as ArrayList<Coche>)}
                    5->{adaptadorCoche.cambioLista(adaptadorCoche.listaCoche.filter { it.precio<=500000 }as ArrayList<Coche>)}
                }
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


    private fun configurarRecycler() {
        // 2. poner un adaptador dentro del recycler
        binding.listaRecycler.adapter = adaptadorCoche
        // 3. poner un layout dentro del recycler --> Linear Grid
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            binding.listaRecycler.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        } else {
            binding.listaRecycler.layoutManager = GridLayoutManager(this, 2)
        }
    }

    private fun instancias() {
        //1. tener una lista de datos a representar
        listaCoches = ArrayList()
        listaCoches.add(Coche("Mercedes", "AMG GT", 200, 149048, R.drawable.amggt))
        listaCoches.add(Coche("Bentley", "Continental", 200, 245676, R.drawable.continental))
        listaCoches.add(Coche("Jaguar", "Ftype", 200, 76450, R.drawable.ftype))
        listaCoches.add(Coche("Ford", "GT40", 200, 2500000, R.drawable.gt40))
        listaCoches.add(Coche("Nissan", "GTR", 200, 111290, R.drawable.gtr))
        listaCoches.add(Coche("Porsche", "Huayra", 200, 2600000, R.drawable.huayra))
        listaCoches.add(Coche("Lexus", "Lc", 200, 130500, R.drawable.lc))
        listaCoches.add(Coche("Ferrari", "La Ferrari", 200, 1300000, R.drawable.leferrari))
        listaCoches.add(Coche("Maclaren", "MC720", 200, 284700, R.drawable.mc600))
        listaCoches.add(Coche("Toyota", "Supra", 200, 56550, R.drawable.supra))
        listaCoches.add(Coche("Porsche", "Taycan", 200, 91024, R.drawable.taycan))

        adaptadorCoche = AdapterCoche(listaCoches, this)

        binding.spinnerMarca.adapter = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.lista_marcas,
            android.R.layout.simple_spinner_item
        )
        (binding.spinnerMarca.adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerPrecio.adapter = ArrayAdapter.createFromResource(
            applicationContext,
            R.array.lista_precios,
            android.R.layout.simple_spinner_item
        )
        (binding.spinnerPrecio.adapter as ArrayAdapter<CharSequence>).setDropDownViewResource(
            android.R.layout.simple_spinner_dropdown_item
        )
        listaFiltrada = ArrayList()
    }

    override fun OnCocheSelected(coche: Coche) {
        var intent: Intent = Intent(applicationContext, DetalleActivity::class.java)
        var datos: Bundle = Bundle()
        datos.putSerializable("coche", coche)
        intent.putExtras(datos)
        startActivity(intent)
    }
}