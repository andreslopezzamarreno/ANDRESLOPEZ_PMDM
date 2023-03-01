package com.example.proyectologin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectologin.databinding.ActivitySecondBinding
import com.example.proyectologin.model.Producto
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SecondActivity : AppCompatActivity() {
    private var nombre: String? = null
    private var uid: String? = null
    private lateinit var db: FirebaseDatabase
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        db =
            FirebaseDatabase.getInstance("https://fir-ces-alz-default-rtdb.firebaseio.com/")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initGUI()

        binding.textBienvenida.text = "Bienvenido: " + nombre

        binding.botonAgregar.setOnClickListener {
            val referencia = db.getReference("usuarios")
                .child(uid.toString())
                .child("productos_fav")
                .child(binding.editNombreProducto.text.toString())

            referencia.child("nombre").setValue(binding.editNombreProducto.text.toString())
            referencia.child("valor").setValue(binding.editValorProducto.text.toString())
        }

        binding.botonRecuperar.setOnClickListener {
            db.getReference("usuarios").child(uid.toString()).child("procuctos_fav")
                .addValueEventListener(object:ValueEventListener{
                    override fun onDataChange(snapshot: DataSnapshot) {
                        //snapshot -> estado actual

                        for (i in snapshot.children){
                            val producto = i.getValue(Producto::class.java)

                        }
                    }

                    override fun onCancelled(error: DatabaseError) {
                        //error en la comunicacion
                    }

                })
        }
    }


    private fun initGUI() {
        nombre = intent.extras!!.getString("nombre")
        uid = intent.extras!!.getString("uid")

        db.getReference("usuarios")
            .child(uid.toString())
            .child("nombre")
            .setValue(nombre)
    }
}