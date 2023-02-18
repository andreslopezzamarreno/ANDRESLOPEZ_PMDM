package com.example.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class SecondActivity : AppCompatActivity() {


    lateinit var textoNombre: TextView
    lateinit var imagenAndroid: ImageView
    lateinit var nombreRecuperado: String
    var edadRecuperada: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // TextView
        instacias()
        recuperarDatos()
        iniciarUI()
    }

    private fun iniciarUI() {
        // textoNombre lo recuperado del Bundle
        textoNombre.setText(nombreRecuperado + resources.getString(R.string.saludoRecuperado))
    }

    private fun recuperarDatos() {
        var bundleRecuperado: Bundle? = intent.extras
        nombreRecuperado = bundleRecuperado?.getString("nombre","por defecto").toString()
        edadRecuperada = bundleRecuperado?.getInt("edad",18) ?: 0
    }

    private fun instacias() {
        textoNombre = findViewById(R.id.texto_nombre)
        imagenAndroid = findViewById(R.id.imagen_android)
    }
}