package com.example.menus

import android.app.AlertDialog
import android.app.AlertDialog.Builder
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class Dialogo:DialogFragment() {

    private lateinit var vista: View
    private lateinit var boton: Button
    private lateinit var edit: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder= AlertDialog.Builder(requireContext())

        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_add,null)
        builder.setView(vista)

        return builder.create()
    }

    fun instancias(){
        boton = vista.findViewById(R.id.boton_add)
        edit = vista.findViewById(R.id.edit_add)
    }

    fun clickar(){
        boton.setOnClickListener{

        }
    }


    override fun onStart() {
        super.onStart()
        instancias()
    }
}