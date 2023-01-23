package com.example.notas

import android.app.AlertDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoHora:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendario = Calendar.getInstance()

        val dialogo = TimePickerDialog(requireContext(),requireContext() as OnTimeSetListener,
            calendario.get(Calendar.HOUR_OF_DAY),calendario.get(Calendar.MINUTE),true)

        return dialogo
    }

}