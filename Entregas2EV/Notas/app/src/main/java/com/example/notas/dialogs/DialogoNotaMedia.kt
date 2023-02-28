package com.example.notas.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.notas.R

class DialogoNotaMedia : DialogFragment() {

    private lateinit var vista: View
    private lateinit var notaMedia: EditText
    private lateinit var botonContinuar: Button
    private lateinit var interfaz: OnDialogoNotaMediaListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as OnDialogoNotaMediaListener
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        vista =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_nota_media_view, null)

        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        notaMedia = vista.findViewById(R.id.edit_nota_media)
        botonContinuar = vista.findViewById(R.id.boton_nota_media)
    }

    override fun onResume() {
        super.onResume()
        botonContinuar.setOnClickListener {
            interfaz.onDiagloNotaMediaListener(notaMedia.text.toString().toDouble())
            dismiss()
        }
    }

    interface OnDialogoNotaMediaListener {
        fun onDiagloNotaMediaListener(notaMedia: Double)
    }
}