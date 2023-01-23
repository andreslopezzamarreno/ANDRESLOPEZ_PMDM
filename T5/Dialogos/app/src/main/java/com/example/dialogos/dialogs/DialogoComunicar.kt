package com.example.dialogos.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoComunicar:DialogFragment() {

    private lateinit var nombre:String
    private lateinit var mensaje:String

    companion object{
        //Lo que este declarado aqui es accesible directamente
        // 1. Creo un metodo newInstance como parametro paso lo que va a revibir el dialogo
                //Devuleve el objeto del tipo que quiere comunicar

        fun newInstance(nombre: String):DialogoComunicar {

            val dialogo = DialogoComunicar()

            //2. Creo los argumentos con los datos que van en los parametros
            //y se lo pongo al cuadro de dialogo
            val bundle = Bundle()
            bundle.putString("nombre",nombre)
            bundle.putString("mensaje","Esto es un ejemplo de mensaje pasado")
            dialogo.arguments = bundle

            return dialogo

        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        //3. Recupero todos los argumentos que quiera utilizar
        nombre = this.arguments?.getString("nombre") ?: "Sin nombre"
        mensaje = this.arguments?.getString("mensaje") ?: "Sin Mensaje"
    }

    //cuadro de dialogo
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())

        builder.setTitle(nombre)
        builder.setMessage(mensaje)

        return builder.create()
    }
}