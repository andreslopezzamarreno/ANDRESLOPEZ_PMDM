package com.example.calculadora

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var texto: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        acciones()
    }

    private fun acciones() {
        binding.botonCero.setOnClickListener(this)
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres.setOnClickListener(this)
        binding.botonCuatro.setOnClickListener(this)
        binding.botonCinco.setOnClickListener(this)
        binding.botonSeis.setOnClickListener(this)
        binding.botonSiete.setOnClickListener(this)
        binding.botonOcho.setOnClickListener(this)
        binding.botonNueve.setOnClickListener(this)
        binding.botonAC.setOnClickListener(this)

        binding.botonMasMenos.setOnClickListener(this)
        binding.botonPorcentaje.setOnClickListener(this)
        binding.botonDivision.setOnClickListener(this)
        binding.botonMultiplicar.setOnClickListener(this)
        binding.botonResta.setOnClickListener(this)
        binding.botonSuma.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)

        binding.factorial?.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        texto = binding.textNumeros.text.toString()
        when (p0!!.id) {
            R.id.botonCero -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonUno -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonDos -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonTres -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonCuatro -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonCinco -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonSeis -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonSiete -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonOcho -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonNueve -> {
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonAC->{
                binding.textNumeros.text = ""
            }


            /*R.id.botonMasMenos->{
                
            }
            R.id.factorial->{
            }*/
        }
    }
}