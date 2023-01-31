package com.example.menus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.menus.adapter.AdapterPalabras
import com.example.menus.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listaPalabras: ArrayList<String>
    private lateinit var adaptador: AdapterPalabras

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Poner toolbar como ActionBar
        setSupportActionBar(binding.toolbar)
        //cambios en el toolbar
        supportActionBar?.title = "Cambio en el titulo"

        configurarRecycler()
    }

    private fun configurarRecycler() {
        listaPalabras = ArrayList()
        adaptador = AdapterPalabras(this, listaPalabras)
        binding.recycler.adapter = adaptador
        binding.recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var texto = ""
        when(item.itemId){
            //sacar un sanckbar  en cada uno de los item pulsado
            R.id.menu_op1 -> {
                texto = "Opcion 1"
            }
            R.id.menu_op2 -> {
                texto = "Opcion compartir"
            }
            R.id.menu_op1_1 -> {
                texto = "Opcion 1.1"
            }
            R.id.menu_op1_2 -> {
                texto = "Opcion 1.2"
            }
            R.id.item_agregar -> {

                adaptador.addPalabra("Prueba")
            }
            R.id.item_vaciar -> {
                adaptador.clearPalabra()
            }
            else ->{
                texto = "Opcion No identificado"
            }
        }
        //Snackbar.make(binding.root,texto,Snackbar.LENGTH_SHORT).show()

        return true
    }
}