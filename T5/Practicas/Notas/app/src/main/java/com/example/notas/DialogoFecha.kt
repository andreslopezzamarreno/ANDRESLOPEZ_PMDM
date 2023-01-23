package com.example.notas

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoFecha :DialogFragment(){


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendario = Calendar.getInstance()
        val dialogo = DatePickerDialog(requireContext(),requireContext() as OnDateSetListener,calendario.get(Calendar.YEAR),
            calendario.get(Calendar.MONTH)+1,calendario.get(Calendar.DAY_OF_MONTH))

        return dialogo
    }
}