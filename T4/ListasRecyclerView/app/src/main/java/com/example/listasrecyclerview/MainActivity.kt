package com.example.listasrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listasrecyclerview.adapter.AdaptadorUsuarios
import com.example.listasrecyclerview.databinding.ActivityMainBinding
import com.example.listasrecyclerview.model.Usuario
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),AdaptadorUsuarios.OnRecyclerUsuarioListener {

    private lateinit var binding : ActivityMainBinding
    private lateinit var listaUsuario: ArrayList<Usuario>
    private lateinit var adaptadorUsuarios: AdaptadorUsuarios;

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
        binding.listaRecycler.adapter = adaptadorUsuarios;
        // 3. poner un layout dentro del recycler --> Linear Grid
        binding.listaRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        //binding.listaRecycler.layoutManager = GridLayoutManager(this,2)
    }

    private fun instancias() {
        listaUsuario = ArrayList()
        listaUsuario.add(Usuario("Borja","Martin",1,R.drawable.male))
        listaUsuario.add(Usuario("andres","Lopez",2,R.drawable.male))
        listaUsuario.add(Usuario("ana","Gomez",3,R.drawable.female))
        listaUsuario.add(Usuario("Lucia","Carrasco",4,R.drawable.female))
        adaptadorUsuarios = AdaptadorUsuarios(listaUsuario, this);

    }

    override fun onUsuarioSelected(usuario: Usuario) {
        Snackbar.make(binding.root,"Comunicado ${usuario.nombre}",Snackbar.LENGTH_SHORT).show()
    }

    override fun onUsuarioSelected(usuario: Usuario, position: Int) {
        Snackbar.make(binding.root,"Comunicado ${usuario.nombre}; Posición:${position}",Snackbar.LENGTH_SHORT).show()
    }
}

