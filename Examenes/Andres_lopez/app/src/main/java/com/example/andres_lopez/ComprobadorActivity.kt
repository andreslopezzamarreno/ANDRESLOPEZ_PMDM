package com.example.andres_lopez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.andres_lopez.databinding.ActivityComprobadorBinding
import com.google.android.material.snackbar.Snackbar

class ComprobadorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComprobadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComprobadorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        acciones()
    }

    private fun instancias() {
        var combustibles = arrayOf<String>("Diesel", "Gasolina", "Hibrido", "Electrico")
        var adpater = ArrayAdapter(this, android.R.layout.simple_spinner_item, combustibles)
        adpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter = adpater
    }


    private fun acciones() {
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var combustible = binding.spinner.selectedItem
                binding.anioMatriculacion.setText("")
                binding.anioMatriculacion.isEnabled = true
                if (combustible.equals("Hibrido")) {
                    binding.anioMatriculacion.setText("2018")
                    binding.anioMatriculacion.isEnabled = false
                } else if (combustible.equals("Electrico")) {
                    binding.anioMatriculacion.setText("2020")
                    binding.anioMatriculacion.isEnabled = false
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        binding.botonComprobar.setOnClickListener {
            if (binding.matricula.text.isEmpty() || binding.anioMatriculacion.text.isEmpty()) {
                var snackbar = Snackbar.make(
                    binding.botonComprobar,
                    "Algun dato está vacío",
                    Toast.LENGTH_SHORT
                ).show()
            } else {


                var combustible = binding.spinner.selectedItem
                if (combustible.equals("Hibrido")) {
                    binding.imagenPegata.setImageResource(R.drawable.etiquetaeco)
                } else if (combustible.equals("Electrico")) {
                    binding.imagenPegata.setImageResource(R.drawable.etiqueta0)
                } else if (combustible.equals("Gasolina")) {
                    if (binding.anioMatriculacion.text.toString().toInt() >= 2006) {
                        binding.imagenPegata.setImageResource(R.drawable.etiquetac)
                    } else if (binding.anioMatriculacion.text.toString()
                            .toInt() >= 2000 && binding.anioMatriculacion.text.toString()
                            .toInt() < 2006
                    ) {
                        binding.imagenPegata.setImageResource(R.drawable.etiquetab)
                    } else if (binding.anioMatriculacion.text.toString().toInt() < 2000) {
                        binding.imagenPegata.setImageResource(R.drawable.etiquetaa)
                    }
                } else if (combustible.equals("Diesel")) {
                    if (binding.anioMatriculacion.text.toString().toInt() >= 2015) {
                        binding.imagenPegata.setImageResource(R.drawable.etiquetac)
                    } else if (binding.anioMatriculacion.text.toString()
                            .toInt() >= 2004 && binding.anioMatriculacion.text.toString()
                            .toInt() < 2015
                    ) {
                        binding.imagenPegata.setImageResource(R.drawable.etiquetab)
                    } else if (binding.anioMatriculacion.text.toString().toInt() < 2004) {
                        binding.imagenPegata.setImageResource(R.drawable.etiquetaa)
                    }
                }
            }
        }
    }
}