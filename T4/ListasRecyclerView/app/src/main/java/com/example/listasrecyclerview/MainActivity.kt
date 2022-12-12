package com.example.listasrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listasrecyclerview.databinding.ActivityMainBinding
import com.example.listasrecyclerview.model.Usuario

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var listaUsuario: ArrayList<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        //tener una lista de datos a representar

        //poner adaptador dentro del recycler

        //poner layout dentro del recyler
        binding.listaRecycler
    }

    private fun instancias() {
        listaUsuario = ArrayList()
        listaUsuario.add(Usuario("Borja","Martin",1,R.drawable.male))
        listaUsuario.add(Usuario("andres","Lopez",2,R.drawable.male))
        listaUsuario.add(Usuario("ana","Gomez",3,R.drawable.female))
        listaUsuario.add(Usuario("Lucia","Carrasco",4,R.drawable.female))
    }
}

