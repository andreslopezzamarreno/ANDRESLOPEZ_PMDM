package com.example.estados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.View.OnClickListener
import com.example.estados.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnClickListener {

    lateinit var binding: ActivityMainBinding
    var contador:Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contador = savedInstanceState?.getInt("contador") ?: 0
        println(contador)
        binding.textoContador.text = contador.toString()
        //binding.textoContador.setText(contador.toString())
        acciones()
    }

    private fun acciones() {
        binding.botonSumar.setOnClickListener (this)
        binding.botonRestar.setOnClickListener (this)
        binding.botonResetear.setOnClickListener (this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.boton_sumar ->{
                contador ++
            }
            R.id.boton_restar ->{
                contador --
            }
            R.id.boton_resetear ->{
                contador = 0
            }
        }
        binding.textoContador.setText(contador.toString())
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador",contador)
    }
}