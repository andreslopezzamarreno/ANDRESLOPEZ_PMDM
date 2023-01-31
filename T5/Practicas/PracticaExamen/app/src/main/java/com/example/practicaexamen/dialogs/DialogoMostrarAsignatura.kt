package com.example.practicaexamen.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.practicaexamen.Asignatura
import com.example.practicaexamen.R

class DialogoMostrarAsignatura:DialogFragment() {

    private lateinit var vista : View
    private lateinit var nombre :TextView
    private lateinit var profesor :TextView
    private lateinit var siglas :TextView
    private lateinit var curso :TextView
    private lateinit var horas :TextView
    private lateinit var ciclo :TextView

    companion object{
        fun newInstance(asignatura: Asignatura): DialogoMostrarAsignatura {
            val args = Bundle()
            args.putSerializable("asignatura", asignatura)
            val fragment = DialogoMostrarAsignatura()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var asignatura = this.arguments?.getSerializable("asignatura") as Asignatura
        println(asignatura.ciclo)
        var builder= AlertDialog.Builder(requireContext())
        builder.setTitle("Asignatura")
        vista = LayoutInflater.from(requireContext()).inflate(R.layout.mostrar_layout,null)
        builder.setView(vista)

        nombre = vista.findViewById(R.id.nombre_asignatura)
        profesor = vista.findViewById(R.id.profesor_asignatura)
        siglas = vista.findViewById(R.id.siglas_asignatura)
        horas = vista.findViewById(R.id.horas_asignatura)
        ciclo = vista.findViewById(R.id.ciclo_asignatura)
        curso = vista.findViewById(R.id.curso_asignatura)

        nombre.setText("Nombre: "+asignatura.nombre)
        profesor.setText("Profesor: "+asignatura.profesor)
        siglas.setText("Siglas: "+asignatura.siglas)
        horas.setText("Horas: "+asignatura.horas)
        ciclo.setText("Ciclo: "+asignatura.ciclo)
        curso.setText("Curso: "+asignatura.curso)

        return builder.create()
    }
}