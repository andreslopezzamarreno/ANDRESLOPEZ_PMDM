package com.example.dialogos.dialogs

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoFecha:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //builder
        //setear elementos del builder
        //return builder.create()
        val calendar:Calendar = Calendar.getInstance()
        val anio= calendar.get(Calendar.YEAR)
        val dia = calendar.get(Calendar.DAY_OF_MONTH)
        val mes = calendar.get(Calendar.MONTH)

        val dialogoFecha =DatePickerDialog(requireContext(),requireContext() as OnDateSetListener,anio,mes,dia)

        return dialogoFecha
    }
}