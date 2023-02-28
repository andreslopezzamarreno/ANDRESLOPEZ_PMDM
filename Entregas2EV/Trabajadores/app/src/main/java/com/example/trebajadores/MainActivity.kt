package com.example.trebajadores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trebajadores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdaptadorRecycler.OnUsuarioListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adaptadorRecycler: AdaptadorRecycler
    private lateinit var usuarios: ArrayList<Usuario>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        instancias()

        binding.botonGuardar.setOnClickListener {
            val nombre = binding.editNombre.text.toString()
            val apellido = binding.editApellido.text.toString()
            val correo = binding.editCorreo.text.toString()
            val edad = binding.editEdad.text.toString()
            val puesto = binding.spinnerPuesto.selectedItem.toString()

            val usuario = Usuario(nombre, apellido, correo, edad.toInt(), puesto)

            adaptadorRecycler.aniadirUsuario(usuario)
        }
    }

    private fun instancias() {
        val adaptador = ArrayAdapter.createFromResource(
            this,
            R.array.puestos,
            android.R.layout.simple_spinner_item
        )
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spinnerPuesto.adapter = adaptador
        usuarios = ArrayList()

        adaptadorRecycler = AdaptadorRecycler(
            this, usuarios
        )

        binding.recyclerUsuarios.adapter = adaptadorRecycler
        binding.recyclerUsuarios.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onUsuarioSelected(usuario: Usuario) {
        DialogoDetalle.newInstance(usuario).show(supportFragmentManager, "")
    }
}