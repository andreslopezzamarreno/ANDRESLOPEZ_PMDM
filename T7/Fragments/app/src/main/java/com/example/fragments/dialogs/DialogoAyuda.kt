package com.example.fragments.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DialogoAyuda:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Dialogo de fragment")

        builder.setMessage("Primera app con fragment")

        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
            dismiss()

        })

        return builder.create()
    }
}