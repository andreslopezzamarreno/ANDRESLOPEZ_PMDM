package com.example.listacoches

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listacoches.databinding.ActivityDetalleBinding
import com.example.listacoches.model.Coche

class DetalleActivity : AppCompatActivity() {

    private lateinit var cocheRecuperado:Coche
    private lateinit var binding: ActivityDetalleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var bundleRecuperado: Bundle? = intent.extras
        cocheRecuperado = bundleRecuperado?.getSerializable("coche") as Coche

        binding.imagenCoche.setImageResource(cocheRecuperado.imagen)
        binding.marcaCoche.setText(cocheRecuperado.marca)
        binding.modeloCoche.setText(cocheRecuperado.modelo)
        binding.cvCoche.setText("CV: "+cocheRecuperado.cv.toString())
        binding.precioCoche.setText("Precio: "+cocheRecuperado.precio.toString())
    }
}