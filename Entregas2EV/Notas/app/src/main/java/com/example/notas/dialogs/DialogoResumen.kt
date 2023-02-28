package com.example.notas.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.notas.R

class DialogoResumen : DialogFragment() {

    private lateinit var vista: View
    private lateinit var nombre: TextView
    private lateinit var hora: TextView
    private lateinit var fecha: TextView
    private lateinit var numAsignaturas: TextView
    private lateinit var notaMedia: TextView


    companion object {
        fun newInstance(
            nombrePasado: String,
            horaPasada: String,
            fechaPasado: String,
            numAsignaturas: String,
            notaMedia: String
        ): DialogoResumen {
            val args = Bundle()
            args.putString("nombreApellido", nombrePasado) ?: ""
            args.putString("hora", horaPasada) ?: ""
            args.putString("fecha", fechaPasado) ?: ""
            args.putString("numAsignaturas", numAsignaturas) ?: ""
            args.putString("notaMedia", notaMedia) ?: ""
            val fragment = DialogoResumen()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())

        vista =
            LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_resumen_final_view, null)

        builder.setView(vista)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        nombre = vista.findViewById(R.id.nombre_dialogo_resumen)
        hora = vista.findViewById(R.id.hora_dialogo_resumen)
        fecha = vista.findViewById(R.id.fecha_dialogo_resumen)
        numAsignaturas = vista.findViewById(R.id.numAsignaturas_dialogo_resumen)
        notaMedia = vista.findViewById(R.id.nota_dialogo_resumen)
        nombre.text = arguments?.getString("nombreApellido")
        hora.text = arguments?.getString("hora")
        fecha.text = arguments?.getString("fecha")
        numAsignaturas.text = arguments?.getString("numAsignaturas")
        notaMedia.text = arguments?.getString("notaMedia")
    }
}