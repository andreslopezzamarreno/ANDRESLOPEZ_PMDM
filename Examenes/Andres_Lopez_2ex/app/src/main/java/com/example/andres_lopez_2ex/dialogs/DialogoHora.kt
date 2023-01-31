package com.example.andres_lopez_2ex.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoHora:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var calendar = Calendar.getInstance()

        var dialogo = TimePickerDialog(requireContext(),requireContext() as OnTimeSetListener,
            calendar.get(Calendar.HOUR),calendar.get(Calendar.HOUR),true)

        return dialogo
    }
}