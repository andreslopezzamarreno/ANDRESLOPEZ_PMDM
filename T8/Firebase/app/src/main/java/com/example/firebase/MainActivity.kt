package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    private lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()
        database = Firebase.database("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonCrear.setOnClickListener {
            auth.createUserWithEmailAndPassword("andres.lopez@cesjuanpablosegundo.es", "ces123")
                .addOnCompleteListener {

                    if (it.isSuccessful) {
                        println("Usuario creado con exito")
                    } else {
                        println("Error en la creacion del usuario")
                    }
                }

            binding.loginUsuario.setOnClickListener {
                auth.signInWithEmailAndPassword("andres.lopez@cesjuanpablosegundo.es", "ces123")
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            println("Usuario logeado con  " + auth.currentUser?.uid)

                        } else {
                            println("Error en el login del usuario")
                        }
                    }
            }

            binding.botonNodo.setOnClickListener {
                //crear la referencia
                database.getReference("ejemplo").setValue("valor nuevo del nodo ejemplo")
                database.getReference("nodo_nuevo").child("ejemplo_hijo").child("nodo_agregar")
                    .setValue("valor del nodo")
            }
        }
    }
}