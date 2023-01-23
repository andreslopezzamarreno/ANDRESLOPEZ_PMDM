package com.example.dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class DialogoListaSimple: DialogFragment() {

    private lateinit var listener: DialogoListaSimple
    private lateinit var elementoSeleccionado:String

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as DialogoListaSimple
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("Opcion 1", "Opcion 2", "Opcion 3")

        builder.setTitle("Elige opcion")

        builder.setSingleChoiceItems(elementos,0, DialogInterface.OnClickListener{ dialogInterface, i ->
            elementoSeleccionado = elementos[i]
        })
        builder.setPositiveButton("Aceptar", DialogInterface.OnClickListener{ dialogInterface, i ->
            //como comunico la seleccion a la interfaz

        })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener{dialogInterface, i ->
            dismiss()
        })
        return builder.create()
    }

    interface OnListaSimpleListener{
        fun onListaSelected(opcion :String)
    }
}