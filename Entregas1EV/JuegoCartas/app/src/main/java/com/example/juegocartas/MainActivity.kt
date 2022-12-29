package com.example.juegocartas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(),OnClickListener {

    lateinit var empezar : Button
    lateinit var textoNombre: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instancias()
        empezar.setOnClickListener(this)

    }

    private fun instancias() {
        empezar = findViewById(R.id.empezar)
        textoNombre = findViewById(R.id.textoNombre)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            R.id.empezar ->{
                if(!textoNombre.text.isEmpty()) {
                    var intent: Intent = Intent(applicationContext, JuegoActivity::class.java)

                    var datos: Bundle = Bundle()
                    datos.putString("nombre", textoNombre.text.toString())
                    intent.putExtras(datos)
                    startActivity(intent)
                }else{
                    Toast.makeText(applicationContext, "Introduce el nombre", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}