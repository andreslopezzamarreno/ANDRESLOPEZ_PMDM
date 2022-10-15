package com.example.t2_inicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var botonPulsar: Button
    lateinit var textoSaludo: TextView
    lateinit var textItroducido: EditText
    lateinit var botonPasar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //xml + kt

        Log.v("ciclo_vida","Metodo onCreate ejecutado")

        botonPulsar = findViewById(R.id.botonPulsar)
        textoSaludo = findViewById(R.id.textoBienvenida)
        textItroducido = findViewById(R.id.textoIntroducido)
        botonPasar = findViewById(R.id.botonPasar)



        //OnClicklistener OnClick -> view el elemento que ha producido el evento
        botonPasar.setOnClickListener({
            //Toast.makeText(applicationContext,"Toast Completada",Toast.LENGTH_SHORT).show()
            //Snackbar.make(it,"Smack completado",Snackbar.LENGTH_SHORT).show()
            var notificacion = Snackbar.make(it, "Snack completado",Snackbar.LENGTH_INDEFINITE)
            notificacion.setAction("Sguro que quieres cerrar",{notificacion.dismiss()})
            notificacion.show()

        })


        botonPulsar.setOnClickListener {
            Log.v("ciclo_vida","boton pulsado")
            /*if (textoSaludo.text.isEmpty()) textoSaludo.text = "primea app finalizada"
            else textoSaludo.setText("")*/
            if(textItroducido.text.isEmpty()) Log.v("ciclo_vida","EditText vacio")
            else textoSaludo.text = textItroducido.text
        }
        //cuando pulse el boton que ponga un texto en el textview

    }
    override fun onStart() {
        super.onStart()
        Log.v("metodo_onstart","Metodo onStart ejecutado")
    }

    override fun onResume() {
        super.onResume()
        Log.v("metodo_resume","Metodo onResume ejecutado")
    }

    override fun onPause() {
        super.onPause()
        Log.v("metodo_onPause","Metodo onPause ejecutado")

    }

    override fun onRestart() {
        super.onRestart()
        Log.v("metodo_onPause","Metodo onRestart ejecutado")

    }

    override fun onStop() {
        super.onStop()
        Log.v("metodo_onPause","Metodo onStop ejecutado")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v("metodo_onPause","Metodo onDestroy ejecutado")

    }
}
