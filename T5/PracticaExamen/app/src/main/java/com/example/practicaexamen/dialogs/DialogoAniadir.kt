package com.example.practicaexamen.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.practicaexamen.adapters.AdapterCiclo
import com.example.practicaexamen.Asignatura
import com.example.practicaexamen.Ciclo
import com.example.practicaexamen.R

class DialogoAniadir:DialogFragment() {

    private lateinit var vista: View
    private lateinit var contexto: Context
    private lateinit var editNombre: EditText
    private lateinit var editProfesor: EditText
    private lateinit var editSiglas: EditText
    private lateinit var spinnerHoras:Spinner
    private lateinit var spinnerCiclo: Spinner
    private lateinit var spinnerCurso:Spinner
    private lateinit var botonAniadir: Button
    private lateinit var interfaz:onDialogoAniadir

    override fun onAttach(context: Context) {
        super.onAttach(context)
        contexto = context
        interfaz = context as onDialogoAniadir
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireContext())
        var adaptadorCiclo: AdapterCiclo
        var listaCiclos:ArrayList<Ciclo> = ArrayList<Ciclo>()

        vista = LayoutInflater.from(contexto).inflate(R.layout.aniadir_layout,null)
        builder.setView(vista)

        editNombre = vista.findViewById(R.id.edit_nombre)
        editProfesor = vista.findViewById(R.id.edit_profesor)
        editSiglas = vista.findViewById(R.id.edit_siglas)
        spinnerHoras = vista.findViewById(R.id.spinner_horas)
        spinnerCiclo = vista.findViewById(R.id.spinner_ciclo)
        spinnerCurso = vista.findViewById(R.id.spinner_curso)
        botonAniadir = vista.findViewById(R.id.boton_aniadir)

        spinnerHoras.adapter = ArrayAdapter.createFromResource(contexto,R.array.horas,android.R.layout.simple_spinner_item)
        (spinnerHoras.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        listaCiclos.add(Ciclo("DAM",R.drawable.dam))
        listaCiclos.add(Ciclo("DAW",R.drawable.daw))
        listaCiclos.add(Ciclo("ASIR",R.drawable.asir))
        adaptadorCiclo = AdapterCiclo(listaCiclos,requireContext())
        spinnerCiclo.adapter = adaptadorCiclo

        spinnerCurso.adapter = ArrayAdapter.createFromResource(contexto,R.array.curso,android.R.layout.simple_spinner_item)
        (spinnerCurso.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return builder.create()
    }

    override fun onResume() {
        super.onResume()
        botonAniadir.setOnClickListener(View.OnClickListener {
           var asignatura = Asignatura(editNombre.text.toString(),editProfesor.text.toString()
            ,editSiglas.text.toString(),spinnerHoras.selectedItem.toString().toInt(),
                (spinnerCiclo.selectedItem as Ciclo).nombre,spinnerCurso.selectedItem.toString().toInt())
            interfaz.asignaturaPasada(asignatura)
            dismiss()
        })
    }

    interface onDialogoAniadir {
        fun asignaturaPasada(asignatura: Asignatura)
    }
}