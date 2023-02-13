package com.example.fragments.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragments.MainActivity
import com.example.fragments.databinding.FragmentUnoBinding
import com.google.android.material.snackbar.Snackbar

class FragmentUno: Fragment() {
    private lateinit var binding: FragmentUnoBinding
    private lateinit var interfaz: OnNombreF1Listener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        interfaz = context as OnNombreF1Listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding  = FragmentUnoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.botonF1.setOnClickListener {
            if(!binding.editF1.text.isEmpty()){
                //Snackbar.make(it,binding.editF1.text,Snackbar.LENGTH_SHORT).show()
                interfaz.onNombreSelected(binding.editF1.text.toString())
            }
        }
    }

    interface OnNombreF1Listener{
        fun onNombreSelected(nombre:String)
    }
}
