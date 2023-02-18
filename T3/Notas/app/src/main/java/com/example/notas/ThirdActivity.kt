package com.example.notas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notas.databinding.ActivityThirdBinding
import com.example.notas.model.Lenguaje
import java.io.Serializable

class ThirdActivity : AppCompatActivity() {

    lateinit var binding : ActivityThirdBinding
    lateinit var asignatura: String
    lateinit var nota_uno: String
    lateinit var nota_dos: String
    lateinit var lenguaje: Lenguaje
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recuperarDatos()
        acciones()
    }

    private fun acciones() {
        binding.aasignaturaPasado.setText(asignatura)
        binding.notaUno.setText("NOTA 1:" +nota_uno.toString())
        binding.notaDos.setText("NOTA 2:" +nota_dos.toString())
        binding.nombreLenguaje.setText(lenguaje.nombre)
        binding.imagenLenguaje.setImageResource(lenguaje.imagen)
    }

    private fun recuperarDatos() {
        var bundleRecuperado: Bundle? = intent.extras
        asignatura = bundleRecuperado?.getString("asignatura","por defecto").toString()
        nota_uno = bundleRecuperado?.getString("notaUno","por defecto").toString()
        nota_dos= bundleRecuperado?.getString("notaDos","por defecto").toString()
        var serializable =  bundleRecuperado?.getSerializable("lenguaje") as Serializable
        lenguaje = serializable as Lenguaje
    }
}