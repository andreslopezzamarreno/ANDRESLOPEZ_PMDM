package com.example.dialogos

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.dialogos.databinding.ActivityMainBinding
import com.example.dialogos.dialogs.*

class MainActivity : AppCompatActivity(),OnClickListener,DialogoConfirmacion.Interfaz,DialogoLista.OnListaListener,
    DialogoListaSimple.OnListaSimpleListener,DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener{

    private lateinit var binding: ActivityMainBinding
    private lateinit var dialogoConfirm: DialogoConfirmacion

    init {
        dialogoConfirm = DialogoConfirmacion()
        dialogoConfirm.funcionNula = {
            if(it){
                Toast.makeText(this, "Pulsado Positivo", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Pulsado Negativo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonConfirmacion.setOnClickListener(this)
        binding.botonLista.setOnClickListener(this)
        binding.botonListaMultiple.setOnClickListener(this)
        binding.botonListaSimple.setOnClickListener(this)
        binding.botonPersonalizado.setOnClickListener(this)
        binding.botonComunicar.setOnClickListener(this)
        binding.botonFecha.setOnClickListener(this)
        binding.botonHora.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0!!.id){
            binding.botonConfirmacion.id->{
                //saltar el cuadro de dialogo
                //show() parte del DialogFragment
                val dialogoConfirmacion = DialogoConfirmacion()
                dialogoConfirmacion.show(supportFragmentManager,"")
            }
            binding.botonLista.id->{
                DialogoLista().show(supportFragmentManager,"")
            }
            binding.botonListaMultiple.id->{

            }
            binding.botonListaSimple.id->{
                DialogoListaSimple().show(supportFragmentManager,"")
            }
            binding.botonPersonalizado.id->{
                DialogoPersonalizado().show(supportFragmentManager,"")
            }
            binding.botonComunicar.id->{
                //lanzar cuadro de dialogo con comunicacion
                DialogoComunicar.newInstance("Andrés").show(supportFragmentManager,"")
            }
            binding.botonFecha.id->{
                DialogoFecha().show(supportFragmentManager,"")
            }
            binding.botonHora.id->{
                DialogoHora().show(supportFragmentManager,"")
            }
        }
    }

    override fun ponerTexto(mensaje: String) {
        binding.textConfirmacion.setText(mensaje)
    }

    override fun ponerTextoLista(mensaje: String) {
        binding.textLista.setText(mensaje)
    }

    override fun onListaSelected(opcion: String) {
        binding.textListaSimple.setText(opcion)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        println("${p1}/${p2+1}/${p3}")
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        println("${p1}:${p2}")
    }


}