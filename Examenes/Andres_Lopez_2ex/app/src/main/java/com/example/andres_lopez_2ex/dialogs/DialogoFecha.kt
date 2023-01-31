package com.example.andres_lopez_2ex.dialogs

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.Calendar

class DialogoFecha:DialogFragment() {

    private lateinit var interfaz: onDialogFecha

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context  as onDialogFecha
    }
    companion object{
        fun newInstance(idBoton:Int): DialogoFecha {
            val args = Bundle()
            args.putInt("id", idBoton)
            val fragment = DialogoFecha()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var id = this.arguments?.get("id")
        var calendar= Calendar.getInstance()
        var dialogo = DatePickerDialog(requireContext(),requireContext() as OnDateSetListener,
        calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH))
        interfaz.enviarId(id as Int)
        return dialogo
    }
    interface onDialogFecha{
        fun enviarId(idBoton: Int)
    }
}