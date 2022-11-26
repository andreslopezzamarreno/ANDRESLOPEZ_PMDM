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
    var operacion:String? = ""
    var op1: Double = 0.0
    var op2: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        operacion = savedInstanceState?.getString("operacion")
        op1 = savedInstanceState?.getDouble("op1")?:0.0
        op2 = savedInstanceState?.getDouble("op2")?:0.0
        binding.textNumeros.setText(savedInstanceState?.getString("texto",""))
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
        binding.botonPunto.setOnClickListener(this)
        binding.botonAC.setOnClickListener(this)
        binding.botonMasMenos.setOnClickListener(this)
        binding.botonPorcentaje.setOnClickListener(this)
        binding.botonSuma.setOnClickListener(this)
        binding.botonResta.setOnClickListener(this)
        binding.botonMultiplicar.setOnClickListener(this)
        binding.botonDivision.setOnClickListener(this)

        binding.botonIgual.setOnClickListener(this)

        binding.factorial?.setOnClickListener(this)
        binding.raiz?.setOnClickListener(this)
        binding.elev?.setOnClickListener(this)
        binding.logaritmo?.setOnClickListener(this)
        binding.e?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
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
            R.id.botonPunto->{
                binding.textNumeros.append((p0 as Button).text)
            }
            R.id.botonAC->{
                binding.textNumeros.text = ""
            }
            R.id.botonMasMenos->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText((op1 * -1).toString())
            }
            R.id.botonPorcentaje->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText((op1 * 0.01).toString())
            }
            R.id.botonSuma->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText("")
                operacion= "+"
            }
            R.id.botonResta->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText("")
                operacion= "-"
            }
            R.id.botonMultiplicar->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText("")
                operacion= "*"
            }
            R.id.botonDivision->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText("")
                operacion= "/"
            }
            R.id.botonIgual->{
                if (binding.textNumeros.text.isEmpty()){
                    binding.textNumeros.setText(op1.toString())
                }else {
                    op2 = binding.textNumeros.text.toString().toDouble()
                    when (operacion) {
                        "+" -> {
                            binding.textNumeros.setText((op1+op2).toString())
                        }
                        "-" -> {
                            binding.textNumeros.setText((op1-op2).toString())
                        }
                        "*" -> {
                            binding.textNumeros.setText((op1*op2).toString())
                        }
                        "/" -> {
                            binding.textNumeros.setText((op1/op2).toString())
                        }
                        "elev"->{
                            binding.textNumeros.setText((Math.pow(op1,op2)).toString())
                        }
                    }
                }
            }

            R.id.raiz->{
                op1 = binding.textNumeros.text.toString().toDouble()

                binding.textNumeros.setText((Math.sqrt(op1)).toString())
            }
            R.id.elev->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText("")
                operacion = "elev"
            }
            R.id.logaritmo->{
                op1 = binding.textNumeros.text.toString().toDouble()
                binding.textNumeros.setText((Math.log(op1)).toString())
            }
            R.id.e->{
                binding.textNumeros.setText((Math.E).toString())
            }

            R.id.factorial->{
                op1 = binding.textNumeros.text.toString().toDouble()
                var factorial: Long = 1
                println(op1.toInt())
                for (i in 1..op1.toInt()) {
                    factorial *= i.toLong()
                }
                binding.textNumeros.setText(factorial.toString())
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("texto",binding.textNumeros.text.toString())
        outState.putString("operacion",operacion)
        outState.putDouble("op1",op1)
        outState.putDouble("op2",op2)
    }
}