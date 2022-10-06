package com.example.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //xml + kt
        botonPulsar = findViewById(R.id.botonPulsar)
        textoSaludo = findViewById(R.id.textoBienvenida)

        botonPulsar.setOnClickListener ({ if(textoSaludo.text.isEmpty()) textoSaludo.setText("Primera app completa")
        else textoSaludo.setText("")})
        //cuando pulse el boton que ponga un texto en el textview

    }
}
