package com.example.notas

import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.notas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),OnTimeSetListener,OnDateSetListener {

    private lateinit var binding: ActivityMainBinding
    private var hora:Int = 0
    private var minutos:Int = 0
    private var anio:Int = 0
    private var mes:Int = 0
    private var dia:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.botonEmpezar.setOnClickListener{
           DialogoHora().show(supportFragmentManager,"")
           DialogoFecha().show(supportFragmentManager,"")
       }

    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        println("${hourOfDay}:${minute}")
        hora = hourOfDay
        minutos = minute
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        anio = year
        mes = month
        dia = dayOfMonth
    }
}