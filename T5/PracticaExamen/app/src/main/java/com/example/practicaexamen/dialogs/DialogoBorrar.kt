package com.example.practicaexamen.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoBorrar:DialogFragment() {


    private lateinit var interfaz:onDialogoBorrar


    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as onDialogoBorrar
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //Builder --> creador
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        //titulo
        //builder.setTitle("Titulo del cuadro de confirmación")
        //darle id de la palabra en Strings
        builder.setTitle("Seguro que quieres borrar")

        //mensaje
        builder.setMessage("¿Estas seguro que quieres borrar?")

        //botones
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
            //Toast.makeText(requireContext(), "Pulsado Positivo", Toast.LENGTH_SHORT).show()
            interfaz.ponerTexto("Positivo")
        })
        builder.setNegativeButton("CANCELAR", DialogInterface.OnClickListener { dialogInterface, i ->
            //Toast.makeText(requireContext(), "Pulsado Negativo", Toast.LENGTH_SHORT).show()
            interfaz.ponerTexto("Negativo")
        })

        return builder.create()
    }

    interface onDialogoBorrar {
        fun ponerTexto(mensaje: String)
    }
}