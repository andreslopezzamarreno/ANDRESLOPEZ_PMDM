package com.example.juegocartas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.delay

class JuegoActivity : AppCompatActivity(), OnClickListener{

    private var carta:Int= -1
    private var carta2:Int= -1
    private lateinit var mayor: ImageButton
    private lateinit var menor: ImageButton
    private lateinit var linearGeneral: LinearLayout
    private var cartas: Array<Int> = arrayOf(R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,R.drawable.c7
            ,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12,R.drawable.c13)
    private lateinit var puntos : TextView
    private var punto: Int = 0
    private lateinit var nombreRecuperado:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_juego)
        instancias()
        recuperarDatos()
        acciones()
        //carta = (Math.random()*13).toInt()
        linearGeneral.setBackgroundResource(R.drawable.cf)
    }

    private fun acciones() {
        mayor.setOnClickListener(this)
        menor.setOnClickListener(this)
        var notificacion = Snackbar.make(mayor, "Bienvenido ${nombreRecuperado}" ,Snackbar.LENGTH_INDEFINITE)
        notificacion.setAction("Empezar") {
            carta = (Math.random()*13).toInt()
            visibleButton()
            linearGeneral.setBackgroundResource(cartas[carta])
        }
        notificacion.show()
    }

    private fun instancias() {
        mayor = findViewById(R.id.mayor)
        menor = findViewById(R.id.menor)
        linearGeneral = findViewById(R.id.linearGeneral)
        puntos = findViewById(R.id.puntos)
        invisibleButton()
    }

    override fun onClick(p0: View?) {
        carta2 = (Math.random()*13).toInt()
        println(carta)
        println(carta2)
        when(p0!!.id){
            R.id.mayor ->{
                if(carta<carta2){
                    juego()
                }else if (carta>carta2) {
                    finJuego()
                }
            }
            R.id.menor ->{
                if(carta>carta2){
                    juego()
                }else if ((carta<carta2)){
                    finJuego()
                }
            }
        }
    }

    fun juego(){
        linearGeneral.setBackgroundResource(cartas[carta2])
        punto ++
        puntos.text = "Puntos " + punto
        carta = carta2
    }

    fun finJuego(){
        //mayor.isEnabled = false
        //menor.isEnabled = false
        invisibleButton()
        linearGeneral.setBackgroundResource(cartas[carta2])
        var notificacion = Snackbar.make(mayor, "Puntos obtenidos: ${punto}" ,Snackbar.LENGTH_INDEFINITE)
        notificacion.setAction("Volver a inicio") {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        notificacion.show()
    }

    private fun recuperarDatos() {
        var bundleRecuperado: Bundle? = intent.extras
        nombreRecuperado = bundleRecuperado?.getString("nombre","por defecto").toString()
    }

    private fun invisibleButton(){
        mayor.isVisible = false
        menor.isVisible = false
    }
    private fun visibleButton(){
        mayor.isVisible = true
        menor.isVisible = true
    }
}