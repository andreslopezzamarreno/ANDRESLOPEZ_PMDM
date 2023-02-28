package com.example.notas.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoAsignaturas : DialogFragment() {

    private lateinit var interfaz: OnDialogoAsignaturasListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as OnDialogoAsignaturasListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        val elementos = arrayOf("PMDM", "DI", "AD", "SGE", "EIE", "ING")
        var elementoSelec = ArrayList<String>()
        builder.setTitle("Elige opcion")

        builder.setMultiChoiceItems(elementos, null) { _, posicion, boolean ->
            elementoSelec.add(elementos[posicion])
        }
        builder.setNeutralButton("Continuar") { _, _ ->
            interfaz.onDialogoAsignaturasSelected(elementoSelec.size)
        }
        return builder.create()
    }

    interface OnDialogoAsignaturasListener {
        fun onDialogoAsignaturasSelected(numeroSeleccionados: Int)
    }
}