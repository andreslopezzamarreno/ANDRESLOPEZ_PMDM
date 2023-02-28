package com.example.notas

import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import com.example.notas.databinding.ActivityMainBinding
import com.example.notas.dialogs.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), OnTimeSetListener, OnDateSetListener,
    DialogoPersonalizado.onDialogoPersonalizadoListener,
    DialogoConfirmacion.OnDialogoConfirmacionListener,
    DialogoAsignaturas.OnDialogoAsignaturasListener, DialogoNotaMedia.OnDialogoNotaMediaListener {

    private lateinit var binding: ActivityMainBinding
    private var hora: Int = 0
    private var minutos: Int = 0
    private var anio: Int = 0
    private var mes: Int = 0
    private var dia: Int = 0
    private lateinit var nombrePasado: String
    private lateinit var apellidoPasado: String
    private var numAsignaturas: Int = 0
    private var notamedia: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonEmpezar.setOnClickListener {
            //Cuadro de diálogo de hora. Por defecto aparecerá la hora de hoy, en formato 12h
            DialogoHora().show(supportFragmentManager, "")
        }
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        hora = hourOfDay
        minutos = minute
        //Cuadro de diálogo de fecha. Por defecto aparecerá la fecha de hoy
        DialogoFecha().show(supportFragmentManager, "")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        anio = year
        mes = month
        dia = dayOfMonth
        //Cuadro de diálogo personalizado donde aparezca un EditText para poder introducir
        //tu nombre y apellido
        DialogoPersonalizado().show(supportFragmentManager, "")
    }

    override fun onDialogoPersonalizadoSelected(nombre: String, apellido: String) {
        nombrePasado = nombre
        apellidoPasado = apellido
        /*
        Cuadro de diálogo de confirmación donde indique el siguiente mensaje: Buenos días Borja
        (nombre que se ha introducido), vas a registrar una respuesta el 17/01 a las 1330.
        ¿Estás seguro que quieres continuar?
         */
        DialogoConfirmacion.newInstance(nombrePasado, "${dia}/${mes + 1}", "${hora}:${minutos}")
            .show(supportFragmentManager, "")
    }

    override fun onDialogoConfirmacionSelected(confirmacion: Boolean) {
        if (confirmacion) {
            /*
            Cuadro de diálogo de selección múltiple. Aparecerá un mensaje donde indique
            ¿De cuantas asignaturas te has evaluado? y una lista donde se podrían seleccionar
            las asignaturas de PMDM, DI, AD, SGE, EIE, ING
             */
            DialogoAsignaturas().show(supportFragmentManager, "")
        } else {
            Snackbar.make(binding.root, "No se ha querido continuar", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDialogoAsignaturasSelected(numeroSeleccionados: Int) {
        numAsignaturas = numeroSeleccionados
        //Cuadro de diálogo personalizado donde se pida introducir la nota media obtenida general
        DialogoNotaMedia().show(supportFragmentManager, "")
    }

    override fun onDiagloNotaMediaListener(notaMedia: Double) {
        notamedia = notaMedia
        /*
        Cuadro de diálogo personalizado donde aparezca un resumen de lo introducido:
        - Nombre y Apellidos: NOMBRE INTRODUCIDO
        - Hora: HORA INTRODUCIDA
        - Fecha: FECHA INTRODUCIDA
        - Número de asignaturas a evaluar: Nº ASIGNATURAS SELECCIONADAS
        - Media obtenida: MEDIA introducida
         */
        DialogoResumen.newInstance(
            nombrePasado + " " + apellidoPasado,
            hora.toString() + ":" + minutos.toString(),
            dia.toString() + "/" + (mes + 1).toString(),
            numAsignaturas.toString(),
            notaMedia.toString()
        ).show(supportFragmentManager, "")
    }


}