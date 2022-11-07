package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var botonUno:Button
    private lateinit var botonDos:Button
    private  var botonTres:Button? =null
    private  var botonCuatro:Button? = null
    private lateinit var editNumeros :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instancias()
        acciones()
    }

    private fun acciones() {
        botonUno.setOnClickListener { this }
        botonDos.setOnClickListener { this }
        botonTres?.setOnClickListener { this }
        botonCuatro?.setOnClickListener { this }
    }

    private fun instancias() {
        botonUno = findViewById(R.id.botonUno)
        botonDos = findViewById(R.id.botonDos)
        botonTres = findViewById(R.id.botonTres)
        botonCuatro = findViewById(R.id.botonCuatro)
        editNumeros = findViewById(R.id.edit_numeros)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.botonUno ->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.botonDos -> {
                editNumeros.append((p0 as Button).text)
            }
            R.id.botonTres ->{
                editNumeros.append((p0 as Button).text)
            }
            R.id.botonCuatro -> {
                editNumeros.append((p0 as Button).text)
            }
        }
    }
}