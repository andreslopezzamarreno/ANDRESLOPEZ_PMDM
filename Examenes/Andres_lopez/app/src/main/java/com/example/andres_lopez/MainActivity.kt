package com.example.andres_lopez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.andres_lopez.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        acciones()
    }

    private fun acciones() {
        binding.botonComprobar.setOnClickListener {
            var intent: Intent= Intent(applicationContext,ComprobadorActivity::class.java)
            startActivity(intent)
        }
        binding.botonModelos.setOnClickListener {
            var intent: Intent= Intent(applicationContext,ModelosActivity::class.java)
            startActivity(intent)
        }
    }
}