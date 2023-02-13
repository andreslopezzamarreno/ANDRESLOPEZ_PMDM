package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.databinding.FragemntDosBinding
import com.example.fragments.databinding.FragmentUnoBinding

class FragmentDos:Fragment() {
    private lateinit var binding: FragemntDosBinding
    private lateinit var nombre:String

    companion object {
        fun newInstance(nombre:String): FragmentDos{
            val args = Bundle()
            args.putString("nombre",nombre)
            val fragment = FragmentDos()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        nombre = this.arguments?.getString("nombre") ?: "No hay nombre"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragemntDosBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.textNombref2.text = "Nombre pasado: ${nombre}"
    }
}