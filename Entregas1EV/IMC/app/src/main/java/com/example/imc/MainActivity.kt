package com.example.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.view.children
import androidx.core.view.isEmpty
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),View.OnClickListener{

    lateinit var botonCalcular:Button
    lateinit var editPeso: EditText
    lateinit var editAltura: EditText
    lateinit var radioSexo: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botonCalcular = findViewById(R.id.calcularImc)
        editPeso = findViewById(R.id.editPeso)
        editAltura = findViewById(R.id.editAltura)
        radioSexo = findViewById(R.id.radioSexo)

        botonCalcular.setOnClickListener(this)
    }

    override fun onClick(boton: View?) {

        when(boton!!.id) {
            R.id.calcularImc->{
                if (editPeso.text.isEmpty()||editAltura.text.isEmpty()){
                    Snackbar.make(boton, "Falta algun dato por rellenar", Snackbar.LENGTH_SHORT).show()
                }else{
                    var radioSexo:RadioButton = findViewById(radioSexo.checkedRadioButtonId)
                    var sexo: String= radioSexo.text.toString()
                    var intent: Intent = Intent(applicationContext,SecondActivity::class.java)
                    var datos: Bundle= Bundle()
                    datos.putDouble("peso",editPeso.text.toString().toDouble())
                    datos.putDouble("altura",editAltura.text.toString().toDouble())
                    datos.putString("sexo",sexo)
                    intent.putExtras(datos)
                    startActivity(intent)
                }
            }
        }
    }


}