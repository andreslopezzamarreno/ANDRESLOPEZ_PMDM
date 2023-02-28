package com.example.notas.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.notas.R
import com.google.android.material.snackbar.Snackbar

class DialogoPersonalizado : DialogFragment() {

    private lateinit var vista: View
    private lateinit var contexto: Context
    private lateinit var nombre: TextView
    private lateinit var apellido: TextView
    private lateinit var botonDialogo: Button
    private lateinit var intefaz: onDialogoPersonalizadoListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(requireContext())

        vista =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_personalizado_view, null)

        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        nombre = vista.findViewById(R.id.nombre_dialogo_personalizado)
        apellido = vista.findViewById(R.id.apellidio_dialogo_personalizado)
        botonDialogo = vista.findViewById(R.id.boton_dialogo_personalizado)
        intefaz = contexto as onDialogoPersonalizadoListener
    }

    override fun onResume() {
        super.onResume()
        botonDialogo.setOnClickListener {
            if (!nombre.text.isEmpty() && !apellido.text.isEmpty()) {
                intefaz.onDialogoPersonalizadoSelected(
                    nombre.text.toString(),
                    apellido.text.toString()
                )
                dismiss()
            }
        }
    }

    interface onDialogoPersonalizadoListener {
        fun onDialogoPersonalizadoSelected(nombre: String, apellido: String)
    }
}