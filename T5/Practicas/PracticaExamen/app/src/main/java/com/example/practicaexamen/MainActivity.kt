package com.example.practicaexamen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaexamen.adapters.RecyclerAdapter
import com.example.practicaexamen.databinding.ActivityMainBinding
import com.example.practicaexamen.dialogs.DialogoAniadir
import com.example.practicaexamen.dialogs.DialogoBorrar
import com.example.practicaexamen.dialogs.DialogoFiltrar

class MainActivity : AppCompatActivity(),DialogoBorrar.onDialogoBorrar,DialogoAniadir.onDialogoAniadir {

    private lateinit var binding : ActivityMainBinding
    private lateinit var listaAsignatura: ArrayList<Asignatura>
    private lateinit var adaptador: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Practica"

        configurarRecycler()
    }

    private fun configurarRecycler() {
        listaAsignatura = ArrayList()
        adaptador = RecyclerAdapter(this, listaAsignatura,supportFragmentManager)
        binding.recycler.adapter = adaptador
        binding.recycler.layoutManager =LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_añadir->{
                DialogoAniadir().show(supportFragmentManager,"")
            }
            R.id.item_vaciar->{
                DialogoBorrar().show(supportFragmentManager,"")
            }
            R.id.item_filtrar->{
                DialogoFiltrar().show(supportFragmentManager,"")
            }
        }
        return true
    }

    override fun ponerTexto(mensaje: String) {
        if(mensaje == "Positivo"){
            listaAsignatura.clear()
            binding.recycler.adapter?.notifyDataSetChanged()
        }
    }

    override fun asignaturaPasada(asignatura: Asignatura) {
        adaptador.aniadirAsignatura(asignatura)
    }
}