package com.example.trebajadores

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class DialogoDetalle : DialogFragment() {

    private lateinit var vista: View
    private lateinit var nombre: TextView
    private lateinit var apellido: TextView
    private lateinit var correo: TextView
    private lateinit var edad: TextView
    private lateinit var puesto: TextView

    companion object {
        fun newInstance(usuario: Usuario): DialogoDetalle {
            val args = Bundle()
            args.putSerializable("usuario", usuario)
            val fragment = DialogoDetalle()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())

        vista = LayoutInflater.from(requireContext()).inflate(R.layout.dialogo_vista, null)
        builder.setView(vista)
        return builder.create()
    }

    override fun onStart() {
        super.onStart()
        val usuario = arguments?.getSerializable("usuario") as Usuario

        nombre = vista.findViewById(R.id.nombre_dialogo)
        apellido = vista.findViewById(R.id.apellido_dialogo)
        correo = vista.findViewById(R.id.correo_dialogo)
        edad = vista.findViewById(R.id.edad_dialogo)
        puesto = vista.findViewById(R.id.puesto_dialogo)

        nombre.text = usuario.nombre
        apellido.text = usuario.apellido
        correo.text = usuario.correo
        edad.text = usuario.edad.toString()
        puesto.text = usuario.puesto
    }
}