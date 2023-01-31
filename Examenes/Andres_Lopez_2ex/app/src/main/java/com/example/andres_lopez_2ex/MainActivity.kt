package com.example.andres_lopez_2ex

import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.andres_lopez_2ex.adapters.AdaptadorSpinnerIda
import com.example.andres_lopez_2ex.adapters.AdaptadorSpinnerVuelta
import com.example.andres_lopez_2ex.adapters.AdapterRecycler
import com.example.andres_lopez_2ex.databinding.ActivityMainBinding
import com.example.andres_lopez_2ex.dialogs.DialogoFecha
import com.example.andres_lopez_2ex.dialogs.DialogoHora
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),android.view.View.OnClickListener,OnTimeSetListener,
    OnDateSetListener,DialogoFecha.onDialogFecha {

    private lateinit var binding:ActivityMainBinding
    private var anio:Int = 0
    private  var mes:Int =0
    private var dia:Int=0
    private var hora:Int=0
    private var minuto:Int=0
    private var idButton:Int=0
    private lateinit var listaCiudades:ArrayList<Ciudad>
    private lateinit var listaVuelos:ArrayList<Vuelo>
    private lateinit var adaptadorRecycler: AdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Examen"


        instancias()
        binding.horaIda.setOnClickListener(this)
        binding.horaVuelta.setOnClickListener(this)
        binding.botonAdd.setOnClickListener(this)

    }

    private fun instancias() {
        listaCiudades = ArrayList()
        listaCiudades.add(Ciudad("Barcelona",R.drawable.barcelona))
        listaCiudades.add(Ciudad("Londres",R.drawable.londres))
        listaCiudades.add(Ciudad("Madrid",R.drawable.madrid))
        listaCiudades.add(Ciudad("Miami",R.drawable.miami))
        listaCiudades.add(Ciudad("New York",R.drawable.newyork))
        listaCiudades.add(Ciudad("San Francisco",R.drawable.sanfrancisco))
        binding.spinnerIda.adapter = AdaptadorSpinnerIda(this,listaCiudades)
        binding.spinnerVuelta.adapter = AdaptadorSpinnerVuelta(this,listaCiudades)

        listaVuelos = ArrayList()
        adaptadorRecycler = AdapterRecycler(this,listaVuelos)
        binding.recycler.adapter = adaptadorRecycler
        binding.recycler.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
    }

    override fun onClick(p0: View?) {
        when (p0?.id){
            binding.horaIda.id->{
                var dialogo =DialogoFecha.newInstance(p0.id)
                dialogo.show(supportFragmentManager,"")
            }
            binding.horaVuelta.id->{
                var dialogo =DialogoFecha.newInstance(p0.id)
                dialogo.show(supportFragmentManager,"")
            }
            binding.botonAdd.id->{
                var info= (binding.spinnerIda.selectedItem as Ciudad).nombre + "-"+ (binding.spinnerVuelta.selectedItem as Ciudad).nombre
                var vuelo = Vuelo(info,(binding.spinnerIda.selectedItem as Ciudad).imagen,(binding.spinnerVuelta.selectedItem as Ciudad).imagen,
                binding.horaIda.text.toString(),binding.horaVuelta.text.toString())
                adaptadorRecycler.aniadirVuelo(vuelo)
            }
        }
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        hora = hourOfDay
        minuto = minute
        if (idButton.equals(binding.horaIda.id)){
            binding.horaIda.text= "${dia}/${mes}/${anio}  ${hora}:${minuto}"
        }else{
            binding.horaVuelta.text= "${dia}/${mes}/${anio}  ${hora}:${minuto}"
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        anio = year
        mes = month
        dia = dayOfMonth
        DialogoHora().show(supportFragmentManager,"")
    }

    override fun enviarId(idBoton: Int) {
        idButton= idBoton
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_cerrar->{
                finish()
            }
            R.id.item_info->{
                //Snackbar.make(this,"informacion de la aplica",Snackbar.LENGTH_LONG).sh
            }

        }

        return true
    }
}