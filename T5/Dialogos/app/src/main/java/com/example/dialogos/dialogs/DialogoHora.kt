package com.example.dialogos.dialogs

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoHora:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendario = Calendar.getInstance()

        val hora = calendario.get(Calendar.HOUR_OF_DAY)
        val mins = calendario.get(Calendar.MINUTE)

        val dialogo = TimePickerDialog(requireContext(),requireContext() as OnTimeSetListener,hora,mins,true)

        return dialogo
    }
}