package com.example.notas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonIniciar.setOnClickListener {
            if (binding.nombre.text.isEmpty() || binding.apellido.text.isEmpty()) {
                var notification = Snackbar.make(
                    binding.botonIniciar,
                    "Falta algun dato por meter",
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                var intent: Intent = Intent(applicationContext, SecondActivity::class.java)
                //var datos: Bundle = Bundle()
                //intent.putExtras(datos)
                startActivity(intent)

            }
        }
    }
}