package com.example.dialogos.dialogs

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dialogos.R

class DialogoConfirmacion : DialogFragment() {

    //crear interfaz
    //crear objeto de interfaz
    //inicializo el objeto --> listener = contexto
    //llamo al metodo desde la pulsacion o accion que quiera
    //inplementarla en el destino
    //utilizo los metodos implementados

    private lateinit var interfaz: Interfaz
    var funcionNula: ((Boolean) -> Unit)? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as Interfaz
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        //Builder --> creador
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

        //titulo
        //builder.setTitle("Titulo del cuadro de confirmación")
        //darle id de la palabra en Strings
        builder.setTitle(resources.getString(R.string.titulo_dialogo))

        //mensaje
        builder.setMessage("¿Estas seguro que quieres continuar?")

        //botones
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
            //Toast.makeText(requireContext(), "Pulsado Positivo", Toast.LENGTH_SHORT).show()
            interfaz.ponerTexto("Positivo")
            funcionNula?.invoke(true)
        })
        builder.setNegativeButton("CANCELAR", DialogInterface.OnClickListener { dialogInterface, i ->
            //Toast.makeText(requireContext(), "Pulsado Negativo", Toast.LENGTH_SHORT).show()
            interfaz.ponerTexto("Negativo")
            funcionNula?.invoke(false)
        })

        return builder.create()
    }


    override fun onDetach() {
        super.onDetach()
    }

    interface Interfaz {
        fun ponerTexto(mensaje: String)
    }


    //Dependiendo de la pulsacion se contesta a la activity el resultado
    //en caso de ser neutral, desaparece el cuadro
}