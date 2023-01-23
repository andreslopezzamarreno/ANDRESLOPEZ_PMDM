package com.example.dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoLista:DialogFragment() {

    private lateinit var interfaz: OnListaListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as OnListaListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")

        builder.setTitle("Elige opcion")

        builder.setItems(elementos, DialogInterface.OnClickListener{dialogInterface, i ->
            //i --> posicion pulsada
            interfaz.ponerTextoLista(elementos.get(i))
        })
        //no hay que poner botones --> como mucho pongo el neutral

        return builder.create()
    }

    interface OnListaListener {
        fun ponerTextoLista(mensaje: String)
    }
}