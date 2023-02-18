package com.example.notas

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.notas.adapters.AdaptadorPersonalizado
import com.example.notas.databinding.ActivitySecondBinding
import com.example.notas.model.Lenguaje
import java.io.Serializable

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding
    lateinit var arraySpinner :ArrayList<Lenguaje>
    lateinit var adaptadorSpinner: AdaptadorPersonalizado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instancias()
        asociarDatos()
        acciones()
    }

    private fun asociarDatos() {
        binding.spinner.adapter = adaptadorSpinner
    }

    private fun instancias() {
        arraySpinner = ArrayList()
        rellenarArraySpinner()
        adaptadorSpinner = AdaptadorPersonalizado(arraySpinner,this)
    }

    private fun rellenarArraySpinner(){
        arraySpinner.add(Lenguaje("PYTHON",R.drawable.python))
        arraySpinner.add(Lenguaje("JAVA",R.drawable.java))
        arraySpinner.add(Lenguaje("KOTLIN",R.drawable.kotlin))
        arraySpinner.add(Lenguaje("SQL",R.drawable.sql))
        arraySpinner.add(Lenguaje("JS",R.drawable.js))
    }
    private fun acciones() {
        binding.botonCalcular.setOnClickListener {
            var intent: Intent = Intent(applicationContext,ThirdActivity::class.java)
            var datos: Bundle = Bundle()
            var asignatura: RadioButton = findViewById(binding.asignaturas.checkedRadioButtonId)
            datos.putString("asignatura",asignatura.text.toString())
            datos.putString("notaUno",binding.notaUno.text.toString())
            datos.putString("notaDos",binding.notaDos.text.toString())
            datos.putSerializable("lenguaje",binding.spinner.selectedItem as Serializable)
            intent.putExtras(datos)
            startActivity(intent)
        }
    }
}