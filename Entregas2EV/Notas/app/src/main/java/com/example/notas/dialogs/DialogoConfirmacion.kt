package com.example.notas.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoConfirmacion : DialogFragment() {

    private lateinit var nombre: String
    private lateinit var fecha: String
    private lateinit var hora: String
    private lateinit var interfaz: OnDialogoConfirmacionListener

    companion object {
        fun newInstance(nombre: String, fecha: String, hora: String): DialogoConfirmacion {
            val args = Bundle()
            args.putString("nombre", nombre)
            args.putString("fecha", fecha)
            args.putString("hora", hora)
            val fragment = DialogoConfirmacion()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as OnDialogoConfirmacionListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())
        nombre = arguments?.getString("nombre") ?: ""
        fecha = arguments?.getString("fecha") ?: ""
        hora = arguments?.getString("hora") ?: ""
        builder.setTitle("Buenos días ${nombre}, vas a registrar una respuesta el ${fecha} a las ${hora}.")

        builder.setMessage("¿Estás seguro que quieres continuar?")

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            interfaz.onDialogoConfirmacionSelected(true)
        })
        builder.setNegativeButton("CANCELAR", DialogInterface.OnClickListener { dialog, which ->
            interfaz.onDialogoConfirmacionSelected(false)
        })

        return builder.create()
    }

    interface OnDialogoConfirmacionListener {
        fun onDialogoConfirmacionSelected(confirmacion: Boolean)
    }
}
