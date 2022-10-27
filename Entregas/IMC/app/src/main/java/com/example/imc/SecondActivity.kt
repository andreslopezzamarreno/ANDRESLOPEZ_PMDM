package com.example.imc

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity: AppCompatActivity(){

    var pesoRecuperado: Double = 0.0
    var alturaRecuperada: Double =0.0
    lateinit var sexoRecuperado: String
    lateinit var mensaje:String
    var imc = 0.0;
    lateinit var textoImc:TextView
    lateinit var textoMensaje:TextView
    lateinit var imagen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recuperarDatos()
        calcularImc()
        instacias()
        iniciarUI()
    }

    private fun instacias() {
        textoImc = findViewById(R.id.imc)
        textoMensaje= findViewById(R.id.mensaje)
        imagen = findViewById(R.id.imagen)
    }

    private fun calcularImc() {
        imc = pesoRecuperado/Math.pow(alturaRecuperada,2.0)
        if (sexoRecuperado == "Hombre"){
            when(imc){
                in 0.0..18.5 -> mensaje = "BAJO PESO"
                in 18.5..24.9 -> mensaje = "PESO NORMAL"
                in 25.0..29.9 -> mensaje = "SOBREPESO"
                in 30.0..34.9 -> mensaje = "OBESIDAD CLASE I"
                in 35.0..39.9 -> mensaje = "OBESIDAD CLASE II"
                in 40.0..1000.0 -> mensaje = "OBESIDAD CLASE III"

            }
        }else{
            when(imc){
                in 0.0..16.5 -> mensaje = "BAJO PESO"
                in 16.5..22.9 -> mensaje = "PESO NORMAL"
                in 23.0..25.9 -> mensaje = "SOBREPESO"
                in 26.0..30.9 -> mensaje = "OBESIDAD CLASE I"
                in 31.0..33.9 -> mensaje = "OBESIDAD CLASE II"
                in 34.0..1000.0 -> mensaje = "OBESIDAD CLASE III"
            }
        }
    }

    private fun recuperarDatos() {
        var bundleRecuperado: Bundle? = intent.extras
        pesoRecuperado = bundleRecuperado?.getDouble("peso",0.0) ?: 0.0
        alturaRecuperada = bundleRecuperado?.getDouble("altura",0.0) ?: 0.0
        sexoRecuperado = bundleRecuperado?.getString("sexo","hombre")!!
    }

    private fun iniciarUI() {
        val df = DecimalFormat("#.##")
        textoImc.setText("IMC: " + df.format(imc))
        textoMensaje.setText(mensaje)

        when(mensaje){
            "BAJO PESO" -> imagen.setImageResource(R.drawable.bajo)
            "PESO NORMAL" -> imagen.setImageResource(R.drawable.normal)
            "SOBREPESO" -> imagen.setImageResource(R.drawable.sobrepeso)
            "OBESIDAD CLASE I" -> imagen.setImageResource(R.drawable.obesidad1)
            "OBESIDAD CLASE II" -> imagen.setImageResource(R.drawable.obesidad2)
            "OBESIDAD CLASE III" -> imagen.setImageResource(R.drawable.obesidad3)
        }
    }
}