package com.example.practicaexamen.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.example.practicaexamen.R

class DialogoFiltrar:DialogFragment() {


    private lateinit var spinner: Spinner
    private lateinit var adaptador :ArrayAdapter<String>

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var builder = AlertDialog.Builder(requireContext())

        var vista= LayoutInflater.from(requireContext()).inflate(R.layout.filtrar_layout,null)

        builder.setView(vista)


        spinner = vista.findViewById(R.id.spinner_filtro)
        spinner.adapter = ArrayAdapter.createFromResource(requireContext(),R.array.ciclos,android.R.layout.simple_spinner_item)
        (spinner.adapter as ArrayAdapter<*>).setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        return builder.create()
    }

    override fun onStart() {
        super.onStart()

    }

}