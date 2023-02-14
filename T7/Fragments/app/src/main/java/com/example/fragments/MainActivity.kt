package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.fragments.databinding.ActivityMainBinding
import com.example.fragments.fragments.FragmentDos
import com.example.fragments.fragments.FragmentTres
import com.example.fragments.fragments.FragmentUno
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(),OnClickListener,FragmentUno.OnNombreF1Listener{

    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonF1.setOnClickListener (this)
        binding.botonF2.setOnClickListener (this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            binding.botonF1.id->{
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(binding.sitoFragment.id,FragmentUno())
                ft.commit()
            }
            binding.botonF2.id ->{
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(binding.sitoFragment.id,FragmentDos())
                ft.commit()
            }
            binding.botonF3.id ->{

            }
        }
    }

    override fun onDatosSelected(usuario: Usuario) {
        //Toast.makeText(this,nombre,Toast.LENGTH_SHORT).show()
        val fm = supportFragmentManager
        val ft = fm.beginTransaction()
        ft.replace(binding.sitoFragment.id,FragmentTres.newInstance(usuario))
        ft.commit()
        //Snackbar.make(binding.root,nombre,Snackbar.LENGTH_SHORT).show()
    }
}